package com.tongzhuogame.iblog.entity;

import com.tongzhuogame.iblog.constants.CommentConstants;


/**
 * 用户评论
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class Comment extends BaseEntity {
	/** 文章ID */
	private String postId;
	/** 评论者邮箱 */
	private String email;
	/** 评论者网址 */
	private String url;
	/** 评论者IP */
	private String ip;
	/** 评论内容 */
	private String content;
	/** 评论状态 */
	private String status = CommentConstants.TYPE_WAIT;
	/** 评论者的userAgent */
	private String agent;
	/** 父评论的ID */
	private String parent;
	public final String getPostId() {
		return postId;
	}
	public final void setPostId(String postId) {
		this.postId = postId;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getUrl() {
		return url;
	}
	public final void setUrl(String url) {
		this.url = url;
	}
	public final String getIp() {
		return ip;
	}
	public final void setIp(String ip) {
		this.ip = ip;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final String getStatus() {
		return status;
	}
	public final void setStatus(String status) {
		this.status = status;
	}
	public final String getAgent() {
		return agent;
	}
	public final void setAgent(String agent) {
		this.agent = agent;
	}
	public final String getParent() {
		return parent;
	}
	public final void setParent(String parent) {
		this.parent = parent;
	}
	
	
}
