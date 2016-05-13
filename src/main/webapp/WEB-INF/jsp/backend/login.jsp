<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="common/bootstrap.jsp" flush="false" />
<title>登录</title>
</head>
<body style="background-color: #fbfbfb;">
	<div id="login" class="clearfix">
		<c:if test="${msg!=null}"><p class="message">${msg}<br></p></c:if>
		<div id="logo">
			<img title="iBlog" src="./../resource/img/logo.png" />
			<p><a href="${g.domain}" title="不知道自己在哪">&lt;-回到${g.title}</a>
		</div>
		<form id="loginform" method="post">
			<div class="form-group">
	        	<div class="input-group">
	           		<div class="input-group-addon"><i class="icon-user"></i></div>
	           		<input type="text" autocomplete="off" class="form-control" name="username" placeholder="用户名/邮箱" />
	        	</div>
			</div>
			<div class="form-group">
				<div class="input-group">
           			<div class="input-group-addon"><i class="icon-key"></i></div>
           			<input type="password" autocomplete="off" class="form-control" name="password" placeholder="密码" />
         		</div>
       		</div>
       		<div class="checkbox">
         		<label><input type="checkbox" name="remeber" /> 记住我的登录信息</label>
         		<button type="submit" class="btn btn-primary" style="margin-left: 40px;">登录</button>
       		</div>
		</form>
	</div>
</body>
</html>