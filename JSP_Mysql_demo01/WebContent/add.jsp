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

<!-- 引入富文本编辑器 -->
<script type="text/javascript" src="<%=path %>/ckeditor/ckeditor.js"></script>
<title></title>
</head>
<body>
	<form action="saveAdd.jsp">

		标题：<input type="text" name="title"><br> 作者：<input
			type="text" name="author"><br> 内容：
		<textarea name="content" class="ckeditor"></textarea>
		类型：<input type="text" name="type"><br> <input
			type="submit" value="提交">
	</form>

</body>
</html>