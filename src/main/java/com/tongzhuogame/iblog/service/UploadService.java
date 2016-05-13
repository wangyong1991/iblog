package com.tongzhuogame.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tongzhuogame.iblog.entity.Upload;
import com.tongzhuogame.iblog.mapper.BaseMapper;
import com.tongzhuogame.iblog.mapper.UploadMapper;

@Service
public class UploadService extends BaseService<Upload> {
	
	@Autowired
	private UploadMapper uploadMapper;

	@Override
	protected BaseMapper<Upload> getMapper() {
		return uploadMapper;
	}

}
