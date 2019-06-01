<%@page import="org.apache.tomcat.jni.Local"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("admin".equals(username) && "123".equals(password)) {
			response.sendRedirect("index.jsp");

		} else {
			request.setAttribute("mess", "用户名或密码错误！");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	%>
	
	<%
	
		}
	%>
	<br>
	<%=username%><br>
	<%=password%>

</body>
</html>