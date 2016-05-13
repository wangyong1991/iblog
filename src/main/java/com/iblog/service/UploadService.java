package com.iblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iblog.entity.Upload;
import com.iblog.mapper.BaseMapper;
import com.iblog.mapper.UploadMapper;

@Service
public class UploadService extends BaseService<Upload> {
	
	@Autowired
	private UploadMapper uploadMapper;

	@Override
	protected BaseMapper<Upload> getMapper() {
		return uploadMapper;
	}

}
