package com.iblog.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iblog.entity.Tag;
import com.iblog.mapper.TagMapper;

public class TagMapperTest {
	@Autowired
	private TagMapper tagMapper;
	
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-base.xml");
		tagMapper = ctx.getBean(TagMapper.class);
		
	}

	@Test
	public void testInsertBatch() {
		final List<Tag> list = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setCreateTime(new Date());
		tag.setCreator("admin");
		tag.setId("tag0");
		tag.setLastUpdate(new Date());
		tag.setName("Java");
		tag.setPostId("8dGkj66S8d");
		list.add(tag);
		
		Tag tag1 = new Tag();
		tag1.setCreateTime(new Date());
		tag1.setCreator("admin");
		tag1.setId("tag1");
		tag1.setLastUpdate(new Date());
		tag1.setName("Spring");
		tag1.setPostId("8dGkj66S8d");
		list.add(tag1);
		
		Tag tag2 = new Tag();
		tag2.setCreateTime(new Date());
		tag2.setCreator("admin");
		tag2.setId("tag2");
		tag2.setLastUpdate(new Date());
		tag2.setName("Mybatis");
		tag2.setPostId("8dGkj66S8d");
		list.add(tag2);
		
		
		assertTrue(tagMapper.insertBatch(list) > 0);
	}

	@Test
	public void testList() {
		List<Tag> list = tagMapper.list();
		assertEquals(3, list.size());
	}
	
	@Test
	public void testGetTagsByPost() {
		List<String> tagsByPost = tagMapper.getTagsByPost("8dGkj66S8d");
		assertEquals(3, tagsByPost.size());
	}
	
	@Test
	public void testDeleteById(){
		assertEquals(1, tagMapper.deleteById("tag0"));
	}
	
	@Test
	public void testDeleteByPostId(){
		assertEquals(2, tagMapper.deleteByPostId("8dGkj66S8d"));
	}
}
