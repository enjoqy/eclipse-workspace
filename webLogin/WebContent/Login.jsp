<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pig管理平台-登录页面</title>
</head>
<body>
	<%
		
		String rememberMe = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("rememberMe")) {
				rememberMe = cookies[i].getValue();
			}
		}
	%>

	<div
		style="width: 300px; height: 400px; padding: 30px; margin: 100px auto; border: 1px solid red">
		<form action="./verify.jsp">
			用户名：<input type="text" name="username" value="${ cookie.username.value }"><br>
			密码：<input type="password" name="password" value="${ cookie.password.value }"><br> 
			记住我：<input	type="checkbox" name="rememberMe" value="1" <%if("1".equals(rememberMe)){%> checked="checked" <% }%>><br>
			 提交：<input type="submit">

		</form>
	</div>

</body>
</html>