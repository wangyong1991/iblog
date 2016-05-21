package com.iblog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.iblog.service.shiro.StatelessToken;
import com.iblog.service.vo.Global;
import com.iblog.support.CookieRemberManager;
import com.iblog.support.WebConstants;
import com.iblog.support.WebContext;
import com.iblog.support.WebContextFactory;
import com.iblog.utils.Constants;
import com.iblog.utils.ServletUtils;
import com.iblog.utils.Threads;

public class LoginFilter extends OncePerRequestFilter {

	@Autowired
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		WebContext context = WebContextFactory.get();
		if (context != null)
			return;
		try {
			context = new WebContext(request, response);
			context.setUser(CookieRemberManager.extractValidRememberMeCookieUser(request, response));
			// 保存上下文
			WebContextFactory.set(context);
			accessControl();

			boolean ajax = ServletUtils.isAjax(request);
			if (!ajax) {
				request.setAttribute("g", new Global(ServletUtils.getDomain(request)));
			}
			/* 设置domain */
			WebConstants.setDomain(ServletUtils.getDomain(request));
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			if (ServletUtils.isAjax(request)) {
				logger.error("error happend", e);
				response.setContentType("application/json");
				response.setCharacterEncoding(Constants.ENCODING_UTF_8.name());
				response.getWriter().write("{'status':'500','success':false,'msg':'操作失败,服务端出错'}");
			} else {
				handleException(Threads.getRootCause(e), request, response);
			}
		} finally {
			 WebContextFactory.remove();
		     cleanup();
		}
	}

	private void accessControl() {
		WebContext context = WebContextFactory.get();

	    if(context.isLogon()){
	      /* 注意：此处要委托给Realm进行登录 */
	      logger.debug("logon-->" + context.getRequest().getRequestURI());
	      SecurityUtils.getSubject().login(new StatelessToken(context.getUser().getId(), context.getUser().getPassword()));
	    }
	}

	private void cleanup() {
		ThreadContext.unbindSubject();
	}

	private void handleException(Throwable t, HttpServletRequest request, HttpServletResponse response) {
		if (t instanceof AuthorizationException) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			ServletUtils.sendRedirect(response, "/resource/error/unauthenticated.html");
		} else {
			logger.error("error happend", t);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			ServletUtils.sendRedirect(response, "/resource/error/500.html");
		}
	}
}
