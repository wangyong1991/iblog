package com.iblog.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iblog.constants.UserConstants;
import com.iblog.entity.User;
import com.iblog.mapper.UserMapper;

public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-base.xml");
		userMapper = ctx.getBean(UserMapper.class);
		
	}
	
	@Test
	public void testInsert(){
		final User user = new User();
		user.setCreateTime(new Date());
		user.setCreator("admin");
		user.setEmail("zhangsan@tongzhuogame.com");
		user.setId("adX5sfa87fVh");
		user.setLastUpdate(new Date());
		user.setNickName("zhangsan");
		user.setPassword("123456");
		user.setRealName("张三");
		user.setRole(UserConstants.USER_ROLE_EDITOR);
		user.setStatus(UserConstants.USER_STATUS_NORMAL);
		user.setDescription("真的爱你.......");
		int count = userMapper.insert(user);
		assertEquals(1, count);
	}


	@Test
	public void testCount() {
		long count = userMapper.count();
		assertEquals(1, count);
	}
	

	@Test
	public void testLoadById(){
		User user = userMapper.loadById("adX5sfa87fVh");
		assertNotNull(user);
	}
	
	@Test
	public void testLoadByNameAndPass(){
		User user = userMapper.loadByNameAndPass("zhangsan", "123456");
		assertNotNull(user);
	}
	
	@Test
	public void testList() {
		List<User> list = userMapper.list();
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testUpdate(){
		final User user = new User();
		user.setCreateTime(new Date());
		user.setCreator("admin");
		user.setEmail("zhangsan@tongzhuogame.com");
		user.setId("adX5sfa87fVh");
		user.setLastUpdate(new Date());
		user.setNickName("zhangsan");
		user.setPassword("123456");
		user.setRealName("张小三");
		user.setRole(UserConstants.USER_ROLE_EDITOR);
		user.setStatus(UserConstants.USER_STATUS_NORMAL);
		user.setDescription("真的爱你.......");
		assertEquals(1, userMapper.update(user));
	}
	
	@Test
	public void testDelete(){
		assertEquals(1, userMapper.deleteById("adX5sfa87fVh"));
	}
}
