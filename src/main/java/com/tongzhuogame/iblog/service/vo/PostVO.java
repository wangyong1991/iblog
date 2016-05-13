package com.tongzhuogame.iblog.service.vo;

import java.util.List;

import com.tongzhuogame.iblog.entity.Category;
import com.tongzhuogame.iblog.entity.Post;
import com.tongzhuogame.iblog.entity.User;

/**
 * 文章业务对象
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class PostVO extends Post {
	private User user;
	private Category category;
	private List<String> tags;
	public final User getUser() {
		return user;
	}
	public final void setUser(User user) {
		this.user = user;
	}
	public final Category getCategory() {
		return category;
	}
	public final void setCategory(Category category) {
		this.category = category;
	}
	public final List<String> getTags() {
		return tags;
	}
	public final void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
