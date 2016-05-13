package com.iblog.entity;

import com.iblog.constants.PostConstants;


/**
 * 文章页面
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class Post extends BaseEntity {
	/** 文章标题 */
	private String title;
	/** 文章摘要，当type为页面时，该值为null */
	private String excerpt;
	/** 文章内容 */
	private String content;
	/** 文章类型（post/page等） */
	private String type = PostConstants.TYPE_POST;
	/** 父文章ID，主要用于PAGE，只支持两级 */
	private String parent = PostConstants.DEFAULT_PARENT;
	/** 分类ID，主要用于POST */
	private String categoryId;
	/** 文章状态 */
	private String pstatus = PostConstants.POST_PUBLISH;
	/** 评论状态 */
	private String cstatus = PostConstants.COMMENT_OPEN;
	/** 评论数 */
	private int ccount = 0;
	/** 阅读数 */
	private int rcount = 0;
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getExcerpt() {
		return excerpt;
	}
	public final void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final String getType() {
		return type;
	}
	public final void setType(String type) {
		this.type = type;
	}
	public final String getParent() {
		return parent;
	}
	public final void setParent(String parent) {
		this.parent = parent;
	}
	public final String getCategoryId() {
		return categoryId;
	}
	public final void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public final String getPstatus() {
		return pstatus;
	}
	public final void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public final String getCstatus() {
		return cstatus;
	}
	public final void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}
	public final int getCcount() {
		return ccount;
	}
	public final void setCcount(int ccount) {
		this.ccount = ccount;
	}
	public final int getRcount() {
		return rcount;
	}
	public final void setRcount(int rcount) {
		this.rcount = rcount;
	}
	
	
}
