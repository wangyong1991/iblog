package com.iblog.plugin;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mybatis的分页查询插件，通过连接StatementHandler的prepare方法来实现
 * <p>
 * 只要在参数列表中包括PageModel类型的参数是才进行分页。
 * 在多参数情况下，只对第一个PageModel类型的参数生效
 * </p>
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(PageInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

	
}
