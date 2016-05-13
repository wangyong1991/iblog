package com.iblog.mapper;

import java.util.List;

import com.iblog.entity.Tag;

public interface TagMapper extends BaseMapper<Tag> {

	/**
	 * 批量插入标签
	 * @param list
	 * @return
	 */
	int insertBatch(List<Tag> list);
	
	int deleteByPostId(String postId);
	
	List<String> getTagsByPost(String postId);
}
