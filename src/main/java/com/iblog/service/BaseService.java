package com.iblog.service;

import java.util.List;

import com.iblog.entity.BaseEntity;
import com.iblog.mapper.BaseMapper;
import com.iblog.plugin.PageModel;

public abstract class BaseService<T extends BaseEntity> {

	public int insert(T t) {
		return getMapper().insert(t);
	}

	public T loadById(String id) {
		return getMapper().loadById(id);
	}

	public void list(PageModel<T> model) {
		List<T> result = getMapper().list(model);
		model.setContent(result);
	}

	public List<T> list() {
		return getMapper().list();
	}

	public int update(T t) {
		return getMapper().update(t);
	}

	public int deleteById(String id) {
		return getMapper().deleteById(id);
	}

	public long count() {
		return getMapper().count();
	}

	protected abstract BaseMapper<T> getMapper();
}
