package com.iblog.entity;

import com.iblog.constants.UserConstants;

/**
 * 用户信息
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class User extends BaseEntity {
	private String nickName;
	private String realName;
	private String password;
	private String email;
	/* 用户账号状态 */
	private String status = UserConstants.USER_STATUS_NORMAL;
	private String role = UserConstants.USER_ROLE_CONTRIBUTOR;
	private String description;
	public final String getNickName() {
		return nickName;
	}
	public final void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public final String getRealName() {
		return realName;
	}
	public final void setRealName(String realName) {
		this.realName = realName;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getStatus() {
		return status;
	}
	public final void setStatus(String status) {
		this.status = status;
	}
	public final String getRole() {
		return role;
	}
	public final void setRole(String role) {
		this.role = role;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}

	
}
