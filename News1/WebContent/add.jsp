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
		<script type="text/javascript" src="<%=path%>/ckeditor/ckeditor.js"> </script>
	</head>
	<body>
		<form action="saveAdd.jsp" method="post">
			标题：<input type="text" name="title"/><br/>
			内容：<textarea name="content" class="ckeditor"></textarea><br/>
			作者：<input type="text" name="author"/><br/>
			类型：<input type="text" name="type"/><br/>
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>