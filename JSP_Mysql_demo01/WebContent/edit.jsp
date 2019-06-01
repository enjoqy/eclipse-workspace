<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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

<script type="text/javascript" src="<%=path %>/ckeditor/ckeditor.js"></script>

</head>
<body>
	<%
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		//1.加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		Connection connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "1234");
		//3、创建sql执行连接
		//Statement statement = connection.createStatement();
		String sql = "select * from news where id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setInt(1, id);
		//4、编写sql语句，执行并返回结果
		//String sql = "select * from news where id = " + id;
		ResultSet rs = psmt.executeQuery();
		rs.next();
		//5、对返回的结果进行操作
	%>
	<form action="saveEdit.jsp">
		<input type="hidden" name="id" value="<%=id%>"> 
		标题：<input type="text" name="title" value="<%=rs.getString("title")%>"><br>
		作者：<input type="text" name="author" value="<%=rs.getString("author")%>"><br>
		内容：<textarea name="content" class="ckeditor">
			<%=rs.getString("content")%>
			</textarea>
		<%-- 内容：<input type="text" name="content" value="<%=rs.getString("content")%>"><br> --%>
		类型：<input type="text" name="type" value="<%=rs.getString("type")%>"><br>
		<input type="submit" value="提交">
	</form>
	
	<%
		//6、关闭资源
		if (psmt != null) {
			psmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	%>


</body>
</html>