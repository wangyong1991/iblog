package com.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iblog.entity.Link;
import com.iblog.mapper.BaseMapper;
import com.iblog.mapper.LinkMapper;
import com.iblog.plugin.PageModel;

@Service
public class LinkService extends BaseService<Link> {
	
	@Autowired
	private LinkMapper linkMapper;
	
	/**
	 * 分页查询
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public PageModel<Link> list(int pageIndex, int pageSize) {
		PageModel<Link> pageModel = new PageModel<Link>(pageIndex, pageSize);
		list(pageModel);
		return pageModel;
	}

	@Override
	protected BaseMapper<Link> getMapper() {
		return linkMapper;
	}

}
