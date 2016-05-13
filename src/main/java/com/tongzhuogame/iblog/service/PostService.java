package com.tongzhuogame.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tongzhuogame.iblog.entity.Post;
import com.tongzhuogame.iblog.mapper.BaseMapper;
import com.tongzhuogame.iblog.mapper.PostMapper;

@Service
public class PostService extends BaseService<Post> {

	@Autowired
	private PostMapper postMapper;

	@Override
	protected BaseMapper<Post> getMapper() {
		return postMapper;
	}
	
	
}
