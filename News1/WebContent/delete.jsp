
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
		<jsp:useBean id="newsService" class="com.news.service.impl.NewsServiceImpl"/>
	</head>
	<body>
		<%
			Integer id = Integer.valueOf(request.getParameter("id"));
			if(newsService.delNews(id)){
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("index.jsp");
			}
		%>
	</body>
</html>