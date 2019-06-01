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
		<script type="text/javascript" src="<%=path%>/ckeditor/ckeditor.js"> </script>
	</head>
	<body>
		<%
			Integer id = Integer.valueOf(request.getParameter("id"));
			News news = newsService.getNewsById(id);
		%>
		<form action="saveEdit.jsp" method="post">
			<input type="hidden" name="id" value="<%=news.getId()%>"/>
			标题：<input type="text" name="title" value="<%=news.getTitle()%>"/><br/>
			内容：<textarea name="content"  class="ckeditor">
					<%=news.getContent()%>
				  </textarea>
				  <br/>
			作者：<input type="text" name="author" value="<%=news.getAuthor()%>"/><br/>
			类型：<input type="text" name="type" value="<%=news.getType()%>"/><br/>
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>