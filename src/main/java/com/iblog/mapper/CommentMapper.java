package com.iblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iblog.entity.Comment;
import com.iblog.plugin.MapContainer;
import com.iblog.service.vo.CommentVO;

public interface CommentMapper extends BaseMapper<Comment> {

	List<CommentVO> listRecent();

	List<MapContainer> listCountByGroupStatus();

	/**
	 * 根据postId获取被批准的评论和指定creator的评论
	 * 
	 * @param postid
	 * @param creator
	 * @return
	 */
	List<CommentVO> listByPost(@Param("postId") String postid, @Param("creator") String creator);

	/**
	 * 更改comment的状态
	 * 
	 * @param commentId
	 */
	int setStatus(@Param("commentId") String commentid, @Param("status") String status);
}
