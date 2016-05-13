package com.iblog.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.iblog.entity.User;
import com.iblog.plugin.ApplicationContextUtil;
import com.iblog.security.HashCalculator;
import com.iblog.security.Hex;
import com.iblog.service.UserService;
import com.iblog.utils.Constants;
import com.iblog.utils.CookieUtil;
import com.iblog.utils.IdGenerator;

public class CookieRemberManager {
	private static final String COOKIE_KEY = IdGenerator.uuid19();

	public static User extractValidRememberMeCookieUser(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil cookieUtil = new CookieUtil(request, response);
		final String token = cookieUtil.getCookie(Constants.COOKIE_CONTEXT_ID);
		if (StringUtils.isBlank(token)) {
			return null;
		}

		String[] cookieTokens = token.split(":");
		if (cookieTokens.length != 3)
			return null;

		long tokenExpiryTime;
		try {
			tokenExpiryTime = new Long(cookieTokens[1]).longValue();
		} catch (Exception e) {
			return null;
		}
		if (isTokenExpired(tokenExpiryTime)) {
			return null;
		}
		UserService userService = ApplicationContextUtil.getBean(UserService.class);
		User user = userService.loadById(cookieTokens[0]);
		if (user == null)
			return null;
		String expectTokenSignature = makeTokenSignature(cookieTokens[0], tokenExpiryTime, user.getPassword());
		return expectTokenSignature.equals(cookieTokens[2]) ? user : null;
	}

	private static String makeTokenSignature(String userId, long tokenExpiryTime, String password) {
		String s = userId + ":" + Long.toString(tokenExpiryTime) + ":" + password + ":" + COOKIE_KEY;
		return Hex.bytes2Hex(HashCalculator.md5(s.getBytes()));
	}

	private static boolean isTokenExpired(long tokenExpiryTime) {
		return tokenExpiryTime == -1 ? false : tokenExpiryTime < System.currentTimeMillis();
	}

	public static void loginSuccess(HttpServletRequest request, HttpServletResponse response, String userId, String password, boolean remeber) {
		final long tokenExpiryTime = remeber ? System.currentTimeMillis() + 7 * 24 * 3600 : -1;
		CookieUtil cookieUtil = new CookieUtil(request, response);
		String cookieValue = userId + ":" + tokenExpiryTime + ":" + makeTokenSignature(userId, tokenExpiryTime, password);
		if (remeber) {
			cookieUtil.setCookie(Constants.COOKIE_CONTEXT_ID, cookieValue, true, 7 * 24 * 3600);
		} else {
			cookieUtil.setCookie(Constants.COOKIE_CONTEXT_ID, cookieValue, true);
		}
	}

	public static void logout(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil cookieUtil = new CookieUtil(request, response);
		cookieUtil.removeCookie(Constants.COOKIE_CONTEXT_ID);
	}

}
