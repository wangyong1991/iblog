package com.iblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iblog.entity.Post;
import com.iblog.plugin.MapContainer;
import com.iblog.plugin.PageModel;
import com.iblog.service.vo.PostVO;

public interface PostMapper extends BaseMapper<Post> {

	Post getPrevPost(String postId);

	Post getNextPost(String postId);

	List<PostVO> listPage(boolean onlyParent);

	List<MapContainer> listArchive();

	int addRcount(@Param("postId") String postId, @Param("count") int count);

	int addCcount(@Param("commentId") String commentId, @Param("count") int count);

	List<String> listRecent(@Param("nums") int nums, @Param("creator") String creator);

	List<String> listByMonth(PageModel<String> model);

	List<String> listByCategory(PageModel<String> model);

	List<String> listByTag(PageModel<String> model);

	void updateCategory(@Param("oldCategoryIds") List<String> oldCategoryIds, @Param("newCategoryId") String newCategoryId);

}
