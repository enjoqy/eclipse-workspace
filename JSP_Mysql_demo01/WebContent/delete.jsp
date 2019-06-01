<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	</head>
	<body>
		<%
			Integer id = Integer.valueOf(request.getParameter("id"));

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
			String sql = "update news set st = 0 where id = ?";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, id);
			//4、编写sql语句，执行并返回结果
			//String sql = "update news set st = 0 where id = " + id;
			Integer rows = psmt.executeUpdate();
			if(rows > 0){
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("index.jsp");
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