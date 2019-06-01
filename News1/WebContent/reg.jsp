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
		<form action="doReg.jsp" method="post">
			用户名：<input type="text" name="username"/><br/>
			密码：<input type="password" name="password"/><br/>
			<input type="submit" value="注册"/>
		</form>
		已有账号？点击<a href="Login.jsp">登陆</a>
	</body>
</html>