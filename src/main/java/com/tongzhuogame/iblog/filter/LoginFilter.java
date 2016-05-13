package com.tongzhuogame.iblog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tongzhuogame.iblog.service.vo.Global;
import com.tongzhuogame.iblog.support.CookieRemberManager;
import com.tongzhuogame.iblog.support.WebConstants;
import com.tongzhuogame.iblog.support.WebContext;
import com.tongzhuogame.iblog.support.WebContextFactory;
import com.tongzhuogame.iblog.utils.Constants;
import com.tongzhuogame.iblog.utils.ServletUtils;
import com.tongzhuogame.iblog.utils.Threads;

public class LoginFilter extends OncePerRequestFilter {

	@Autowired
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
			throws ServletException, IOException {
		WebContext context = WebContextFactory.get();
	    if(context != null)
	      return;
	    try {
	    	context = new WebContext(request, response);
	    	context.setUser(CookieRemberManager.extractValidRememberMeCookieUser(request, response));
	    	// 保存上下文
	    	WebContextFactory.set(context);
	    	accessControl();
	    	
	    	boolean ajax = ServletUtils.isAjax(request);
	    	if(! ajax) {
	    		request.setAttribute("g", new Global(ServletUtils.getDomain(request)));
	    	}
	    	/* 设置domain */
	    	WebConstants.setDomain(ServletUtils.getDomain(request));
	    	filterChain.doFilter(request, response);
	    }catch(Exception e) {
	    	if(ServletUtils.isAjax(request)){
	            logger.error("error happend", e);
	            response.setContentType("application/json");
	            response.setCharacterEncoding(Constants.ENCODING_UTF_8.name());
	            response.getWriter().write("{'status':'500','success':false,'msg':'操作失败,服务端出错'}");
	          }else{
	            handleException(Threads.getRootCause(e), request, response);
	          }
	    }finally {
	    	WebContextFactory.remove();
	        cleanup();
	    }
	}

	private void accessControl() {
		WebContextFactory.remove();
	    cleanup();
	}

	private void cleanup() {
		// TODO Auto-generated method stub
		
	}
	private void handleException(Throwable t, HttpServletRequest request, HttpServletResponse response){
		
	}
}
