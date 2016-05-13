package com.tongzhuogame.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tongzhuogame.iblog.entity.Comment;
import com.tongzhuogame.iblog.mapper.BaseMapper;
import com.tongzhuogame.iblog.mapper.CommentMapper;

@Service
public class CommentService extends BaseService<Comment> {
	
	@Autowired
	private CommentMapper commentMapper;
	
	

	@Override
	protected BaseMapper<Comment> getMapper() {
		return commentMapper;
	}

}
