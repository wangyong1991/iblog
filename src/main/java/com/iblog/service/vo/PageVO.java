package com.iblog.service.vo;

import java.util.ArrayList;
import java.util.List;

import com.iblog.entity.Post;
import com.iblog.plugin.TreeItem;

/**
 * 页面业务对象
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class PageVO extends Post implements TreeItem<PageVO>{
	private List<PageVO> children;

	public final List<PageVO> getChildren() {
		return children;
	}

	public final void setChildren(List<PageVO> children) {
		this.children = children;
	}

	@Override
	public void addChild(PageVO comment) {
		if(children == null)
	      setChildren(new ArrayList<PageVO>());

	    getChildren().add(comment);
	}
	
	
}
