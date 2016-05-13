package com.iblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iblog.entity.User;
import com.iblog.form.LoginForm;
import com.iblog.service.UserService;
import com.iblog.support.CookieRemberManager;
import com.iblog.support.WebContextFactory;
import com.iblog.utils.Constants;
import com.iblog.utils.CookieUtil;
import com.iblog.utils.ServletUtils;

@Controller
@RequestMapping("/backend")
public class BackendController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
//		if (WebContextFactory.get().isLogon()) {
//			return "redirect:/backend/index";
//		}
		return "backend/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid LoginForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		// 如果入参有问题，返回注册页面
		if (result.hasErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
			for (FieldError error : errorList) {
				request.setAttribute("msg", error.getDefaultMessage());
			}
			return "backend/login";
		}

		User user = userService.login(form.getUsername(), form.getPassword());
		if (user == null) {
			request.setAttribute("msg", "用户名或密码错误");
			return "backend/login";
		}
//		SecurityUtils.getSubject().login(new StatelessToken(user.getId(), user.getPassword()));
		CookieUtil cookieUtil = new CookieUtil(request, response);
		/* 根据RFC-2109中的规定，在Cookie中只能包含ASCII的编码 */
		cookieUtil.setCookie(Constants.COOKIE_USER_NAME, form.getUsername(), false, 7 * 24 * 3600);
		cookieUtil.setCookie(Constants.COOKIE_COMMENT_AUTHOR, user.getNickName(), "/", false, 365 * 24 * 3600);
		cookieUtil.setCookie(Constants.COOKIE_COMMENT_AUTHOR_EMAIL, user.getEmail(), "/", false, 365 * 24 * 3600, false);
		cookieUtil.setCookie(Constants.COOKIE_COMMENT_AUTHOR_URL, ServletUtils.getDomain(request), "/", false, 365 * 24 * 3600, false);

		CookieRemberManager.loginSuccess(request, response, user.getId(), user.getPassword(), form.isRemeber());

		// 这里省略注册代码
		return "redirect:backend/index";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		CookieRemberManager.logout(request, response);
//		SecurityUtils.getSubject().logout();
		CookieUtil cookieUtil = new CookieUtil(request, response);
		cookieUtil.removeCookie(Constants.COOKIE_CSRF_TOKEN);
		cookieUtil.removeCookie(Constants.COOKIE_COMMENT_AUTHOR);
		cookieUtil.removeCookie(Constants.COOKIE_COMMENT_AUTHOR_EMAIL);
		cookieUtil.removeCookie(Constants.COOKIE_COMMENT_AUTHOR_URL);

		return "redirect:/backend/login?msg=logout";
	}
}
