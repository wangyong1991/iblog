package com.iblog.entity;

/**
 * 站点选项
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class Option extends BaseEntity {
	private String name;
	private String value;
	
	public Option(){
	}

	public Option(String name, String value){
		this.name = name;
		this.value = value;
	}
	  
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getValue() {
		return value;
	}
	public final void setValue(String value) {
		this.value = value;
	}
	
	
}
