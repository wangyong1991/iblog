package com.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iblog.entity.Post;
import com.iblog.mapper.BaseMapper;
import com.iblog.mapper.PostMapper;

@Service
public class PostService extends BaseService<Post> {

	@Autowired
	private PostMapper postMapper;

	@Override
	protected BaseMapper<Post> getMapper() {
		return postMapper;
	}
	
	
}
