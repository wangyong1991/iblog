package com.iblog.entity;

public class Link extends BaseEntity {
	private String name;
	private String url;
	/** 注释 */
	private String notes;
	/** 可见性 */
	private boolean visibale = true;
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getUrl() {
		return url;
	}
	public final void setUrl(String url) {
		this.url = url;
	}
	public final String getNotes() {
		return notes;
	}
	public final void setNotes(String notes) {
		this.notes = notes;
	}
	public final boolean isVisibale() {
		return visibale;
	}
	public final void setVisibale(boolean visibale) {
		this.visibale = visibale;
	}
}
