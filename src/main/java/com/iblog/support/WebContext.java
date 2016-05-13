package com.iblog.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iblog.entity.User;

public class WebContext {
	private String sid;
	private int loginId;
	private User user;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public WebContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public final String getSid() {
		return sid;
	}

	public final void setSid(String sid) {
		this.sid = sid;
	}

	public final int getLoginId() {
		return loginId;
	}

	public final void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public final User getUser() {
		return user;
	}

	public final void setUser(User user) {
		this.user = user;
	}

	public final HttpServletRequest getRequest() {
		return request;
	}

	public final void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public final HttpServletResponse getResponse() {
		return response;
	}

	public final void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public final boolean isLogon() {
		return user != null;
	}

}
