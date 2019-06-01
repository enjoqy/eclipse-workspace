<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//1.加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/news", "root", "1234");
			//3.编写SQL语句  创建预处理对象
			String sql = "select count(1) from users where username = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			//4.执行SQL，返回结果
			ResultSet rs = pstmt.executeQuery();
			Integer count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			if(count > 0){
				response.sendRedirect("index.jsp");
			}else{
				//request.setAttribute("mess", "用户名或密码错误！");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		%>
	</body>
</html>