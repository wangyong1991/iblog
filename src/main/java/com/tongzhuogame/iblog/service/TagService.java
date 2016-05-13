package com.tongzhuogame.iblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tongzhuogame.iblog.entity.Tag;
import com.tongzhuogame.iblog.mapper.BaseMapper;
import com.tongzhuogame.iblog.mapper.TagMapper;

@Service
public class TagService extends BaseService<Tag> {

	@Autowired
	private TagMapper tagMapper;
	
	public List<String> listTagsByPost(String postId) {
		return tagMapper.getTagsByPost(postId);
	}
	
	public int insertBatch(List<Tag> tags) {
		return tagMapper.insertBatch(tags);
	}
	
	public int deleteByPostId(String postId) {
		return tagMapper.deleteByPostId(postId);
	}

	@Override
	protected BaseMapper<Tag> getMapper() {
		return tagMapper;
	}
	
	
}
