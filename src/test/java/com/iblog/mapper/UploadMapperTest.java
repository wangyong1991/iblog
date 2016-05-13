package com.iblog.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iblog.entity.Upload;
import com.iblog.mapper.UploadMapper;

public class UploadMapperTest {

	@Autowired
	private UploadMapper uploadMapper;
	
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-base.xml");
		uploadMapper = ctx.getBean(UploadMapper.class);
		
	}

	@Test
	public void testInsert() {
		final Upload upload = new Upload();
		upload.setCreateTime(new Date());
		upload.setCreator("admin");
		upload.setId("s6X9Ljs6");
		upload.setLastUpdate(new Date());
		upload.setName("哈哈");
		upload.setPath("www.baidu.com");
		upload.setPostId("8dGkj66S8d");
		assertEquals(1, uploadMapper.insert(upload));
	}
	
	@Test
	public void testLoadById() {
		Upload upload = uploadMapper.loadById("s6X9Ljs6");
		assertNotNull(upload);
	}
	
	@Test
	public void testList(){
		List<Upload> list = uploadMapper.list();
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testListByPostId() {
		List<Upload> list = uploadMapper.listByPostId("8dGkj66S8d");
		assertEquals(1, list.size());
	}
	
	@Test
	public void testCount() {
		long count = uploadMapper.count();
		assertEquals(1, count);
	}
	
	@Test
	public void testUpdatePostId(){
		
	}
	
	@Test
	public void testSetNullPostId() {
		uploadMapper.setNullPostId("8dGkj66S8d");
		
	}
	
	@Test
	public void testDeleteById(){
		assertEquals(1, uploadMapper.deleteById("s6X9Ljs6"));
	}
	
	@Test
	public void testDeleteByPostId() {
		assertEquals(0, uploadMapper.deleteByPostId("8dGkj66S8d"));
	}
}
