package com.tongzhuogame.iblog.entity;

/**
 * 文章、页面的元数据，如文章包含的页面等
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class Upload extends BaseEntity {
	/** 对应文章ID */
	private String postId;
	/** 图片名称 */
	private String name;
	/** 图片访问路径 */
	private String path;
	public final String getPostId() {
		return postId;
	}
	public final void setPostId(String postId) {
		this.postId = postId;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPath() {
		return path;
	}
	public final void setPath(String path) {
		this.path = path;
	}
	
	
}
