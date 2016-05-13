package com.iblog.service.vo;

import com.iblog.entity.Post;
import com.iblog.entity.Upload;
import com.iblog.entity.User;

/**
 * 附件业务对象
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public class UploadVO extends Upload {
	private Post post;
	private User user;
	public final Post getPost() {
		return post;
	}
	public final void setPost(Post post) {
		this.post = post;
	}
	public final User getUser() {
		return user;
	}
	public final void setUser(User user) {
		this.user = user;
	}
	
}
