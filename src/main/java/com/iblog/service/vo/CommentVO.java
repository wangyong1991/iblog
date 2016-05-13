package com.iblog.service.vo;

import java.util.ArrayList;
import java.util.List;

import com.iblog.entity.Comment;
import com.iblog.entity.Post;
import com.iblog.plugin.TreeItem;

public class CommentVO extends Comment implements TreeItem<CommentVO>{
	private Post post;
	private List<CommentVO> children;
	public final Post getPost() {
		return post;
	}
	public final void setPost(Post post) {
		this.post = post;
	}
	public final List<CommentVO> getChildren() {
		return children;
	}
	public final void setChildren(List<CommentVO> children) {
		this.children = children;
	}
	@Override
	public void addChild(CommentVO comment) {
		if(children == null)
			setChildren(new ArrayList<CommentVO>());

		getChildren().add(comment);
	}
	
	
}
