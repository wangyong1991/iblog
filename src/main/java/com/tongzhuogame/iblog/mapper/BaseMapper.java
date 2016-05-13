package com.tongzhuogame.iblog.mapper;

import java.util.List;

import com.tongzhuogame.iblog.entity.BaseEntity;
import com.tongzhuogame.iblog.plugin.PageModel;

public interface BaseMapper<T extends BaseEntity> {

	/**
	 * 插入记录
	 * @param t
	 * @return
	 */
	int insert(T t);
	
	/**
	 * 根据ID查询记录
	 * @param id
	 * @return
	 */
	T loadById(String id);
	
	/**
	 * 分页查询
	 */
	List<T> list(PageModel<T> model);
	
	List<T> list();
	
	/**
	 * 根据ID删除记录
	 * @param id
	 * @return
	 */
	int deleteById(String id);
	
	/**
	 * 更新记录
	 * @param t
	 * @return
	 */
	int update(T t);
	
	/**
	 * 获取记录总数
	 * @return
	 */
	long count();
}
