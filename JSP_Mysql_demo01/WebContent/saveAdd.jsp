<%@page import="java.sql.PreparedStatement"%>
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
</head>
<body>
	<%
		int id = 0;
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		//1.加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建连接
		Connection connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "1234");
		//3、创建sql执行连接
		//Statement statement = connection.createStatement();
		String sql = "insert into news (title, author, content, type, st) values (?,?,?,?,?)";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, title);
		psmt.setString(2, author);
		psmt.setString(3, content);
		psmt.setString(4, type);
		psmt.setInt(5, 1);
		//4、编写sql语句，执行并返回结果
		//String sql = "insert into news (title, author, content, type) values ('" + title +"', '" + author + "','" + content + "', '" + type + "')";
		Integer rows = psmt.executeUpdate();

		if (rows > 0) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("add.jsp");
		}
	%>

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