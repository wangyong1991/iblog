package com.tongzhuogame.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tongzhuogame.iblog.entity.User;
import com.tongzhuogame.iblog.mapper.BaseMapper;
import com.tongzhuogame.iblog.mapper.UserMapper;
import com.tongzhuogame.iblog.plugin.PageModel;

@Service
public class UserService extends BaseService<User> {

	@Autowired
	private UserMapper userMapper;

	public PageModel<User> list(int pageIndex, int pageSize) {
		PageModel<User> page = new PageModel<>(pageIndex, pageSize);
		super.list(page);
		return page;
	}

	public User login(String username, String password) {
		return userMapper.loadByNameAndPass(username, password);
	}

	@Override
	protected BaseMapper<User> getMapper() {
		return userMapper;
	}

}
