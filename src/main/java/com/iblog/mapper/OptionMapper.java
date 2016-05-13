package com.iblog.mapper;

import com.iblog.entity.Option;

public interface OptionMapper extends BaseMapper<Option> {
	
	String getOptionValue(String name);

	/**
	 * 以select .. for update,注意此方法须在事务中执行
	 * 
	 * @param name
	 * @return
	 */
	String getOptionValueForUpdate(String name);
}
