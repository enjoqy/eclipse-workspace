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
			Integer id = Integer.valueOf(request.getParameter("id")); 
			News news = newsService.getNewsById(id);
		%>
		<h1><%=news.getTitle()%></h1>
		<h4><%=news.getType()%></h4>
		责任编辑：<span><%=news.getAuthor()%></span>
		<div><%=news.getContent()%></div>
	</body>
</html>