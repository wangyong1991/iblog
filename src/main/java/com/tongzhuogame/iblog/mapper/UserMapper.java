package com.tongzhuogame.iblog.mapper;

import org.apache.ibatis.annotations.Param;

import com.tongzhuogame.iblog.entity.User;

public interface UserMapper extends BaseMapper<User> {

	User loadByNameAndPass(@Param("username") String username, @Param("password") String password);
}
