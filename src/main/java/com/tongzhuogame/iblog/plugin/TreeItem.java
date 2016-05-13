package com.tongzhuogame.iblog.plugin;

import java.util.Collection;

public interface TreeItem<T> {

	String getId();
	
	String getParent();
	
	Collection<T> getChildren();
	
	void addChild(T child);
}
