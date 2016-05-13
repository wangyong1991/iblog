package com.iblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iblog.entity.Upload;

public interface UploadMapper extends BaseMapper<Upload> {

	List<Upload> listByPostId(String postId);
	
	/**
	 * 更新上传文件记录对应的文章ID
	 * @param postId
	 * @param imgPaths
	 * @return
	 */
	int updatePostId(@Param("postId") String postId, @Param("imgPaths") List<String> imgPaths);
	
	/**
	 * 将所有postId的记录置空，非删除记录
	 * @param postId
	 */
	void setNullPostId(String postId);
	
	int deleteByPostId(String postId);
}
