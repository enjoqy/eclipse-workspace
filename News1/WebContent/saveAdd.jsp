<%@page import="com.news.pojo.News"%>
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
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String author = request.getParameter("author");
			String type = request.getParameter("type");
			//创建实体类对象
			News news = new News();
			news.setTitle(title);
			news.setContent(content);
			news.setAuthor(author);
			news.setType(type);
			
			if(newsService.addNews(news)){
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("add.jsp");
			}
		%>
		
	</body>
</html>