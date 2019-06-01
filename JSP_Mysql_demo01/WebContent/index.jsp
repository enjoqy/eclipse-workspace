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

<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"></script> --%>

<title></title>
</head>
<body>

	<div>
		<%
			int id = 0;
			String title = "";
			String author = "";
			String content = "";
			String type = "";
			//1.加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接
			Connection connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "1234");
			//3、创建sql执行连接
			Statement statement = connection.createStatement();
			//4、编写sql语句，执行并返回结果
			String sql = "select * from news where st = 1";
			ResultSet rs = statement.executeQuery(sql);
			//5、对返回的结果进行操作
		%>


		<table border="2" cellpadding="10" cellspacing="0">
			<tr>
				<th>id</th>
				<th>title</th>
				<th>author</th>
				<th>content</th>
				<th>type</th>
				<th colspan="2">操作</th>

			</tr>
			<%
				while (rs.next()) {
					//id = rs.getInt("id");
					//title = rs.getString("title");
					//author = rs.getString("author");
					//content = rs.getString("content");
					//type = rs.getString("type");
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><a href='show.jsp'><%=rs.getString("title")%></a></td>
				<td><%=rs.getString("author")%></td>
				<%-- <td><%=rs.getString("content")%></td> --%>
				<td><%=rs.getString("type")%></td>
				<td><a href="delete.jsp?id=<%=rs.getInt("id")%>">删除</a></td>
				<td><a href="edit.jsp?id=<%=rs.getInt("id")%>">修改</a></td>

			</tr>

			<%
				}
			%>

		</table>

		<br>
		<a href="add.jsp">增加一条记录</a>

		<%
			//6、关闭资源
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		%>
	</div>


</body>
</html>