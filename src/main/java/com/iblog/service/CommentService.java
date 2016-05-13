package com.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iblog.entity.Comment;
import com.iblog.mapper.BaseMapper;
import com.iblog.mapper.CommentMapper;

@Service
public class CommentService extends BaseService<Comment> {
	
	@Autowired
	private CommentMapper commentMapper;
	
	

	@Override
	protected BaseMapper<Comment> getMapper() {
		return commentMapper;
	}

}
