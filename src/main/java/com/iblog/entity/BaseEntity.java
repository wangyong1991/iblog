package com.iblog.entity;

import java.util.Date;

public class BaseEntity {

	private String id;
	private Date createTime;
	private String creator;
	private Date lastUpdate;
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final Date getCreateTime() {
		return createTime;
	}
	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public final String getCreator() {
		return creator;
	}
	public final void setCreator(String creator) {
		this.creator = creator;
	}
	public final Date getLastUpdate() {
		return lastUpdate;
	}
	public final void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
