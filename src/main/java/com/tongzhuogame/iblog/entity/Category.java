package com.tongzhuogame.iblog.entity;

public class Category extends BaseEntity {
	private String name;
	private int leftv;
	private int rightv;
	/** 是否显示 */
	private boolean visible = true;
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final int getLeftv() {
		return leftv;
	}
	public final void setLeftv(int leftv) {
		this.leftv = leftv;
	}
	public final int getRightv() {
		return rightv;
	}
	public final void setRightv(int rightv) {
		this.rightv = rightv;
	}
	public final boolean isVisible() {
		return visible;
	}
	public final void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
