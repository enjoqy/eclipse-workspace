<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
	</head>
	<body>
		<form action="doLogin.jsp" method="post">
			用户名：<input type="text" name="username"/><br/>
			密码：<input type="password" name="password"/><br/>
			<input type="submit" value="登陆"/>
		</form>
		没有账号？点击<a href="reg.jsp">注册</a>
	</body>
</html>