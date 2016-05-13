package com.tongzhuogame.iblog.entity;

/**
 * 文章标签信息
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class Tag extends BaseEntity {
	private String name;
	private String postId;
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPostId() {
		return postId;
	}
	public final void setPostId(String postId) {
		this.postId = postId;
	}
	
}
