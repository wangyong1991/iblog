package com.tongzhuogame.iblog.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
	@NotBlank(message = "用户名不能为空")
	@Pattern(regexp = "^[a-zA-Z\u4e00-\u9fa5][_a-zA-Z0-9\u4e00-\u9fa5]{1,14}$", message = "请输入正确的用户名")
	private String username;
	
	@NotBlank(message = "密码不能为空")
	@Pattern(regexp = "^\\S{6,16}$", message = "密码输入有误")
	private String password;
	private boolean remeber;
	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final boolean isRemeber() {
		return remeber;
	}
	public final void setRemeber(boolean remeber) {
		this.remeber = remeber;
	}
	
	
}
