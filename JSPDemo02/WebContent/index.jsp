<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="informations" class="org.zhh.domain.Informations"></jsp:useBean>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
	</head>
	<body>
		<h1>这个是主页</h1>
		<%=path %>
		<br>
		<%=basePath %>
		
		<a href="logout.jsp">注销</a>

	</body>
</html>