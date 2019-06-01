<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>校验登录</title>
</head>
<body>
	开始验证。。。
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String rememberMe = request.getParameter("rememberMe");

	if ("root".equals(username) && "1234".equals(password)) {
		if ("1".equals(rememberMe)) {
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			Cookie rememberMeCookie = new Cookie("rememberMe", rememberMe);
			
			if("1".equals(rememberMe)){
				usernameCookie.setMaxAge(7*24*60*60);
				passwordCookie.setMaxAge(7*24*60*60);
				rememberMeCookie.setMaxAge(7*24*60*60);
			}else {
				usernameCookie.setMaxAge(0);
				passwordCookie.setMaxAge(0);
				rememberMeCookie.setMaxAge(0);
			}
			
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
			response.addCookie(rememberMeCookie);
		}

		session.setAttribute("onlineUsername", username);
		request.getRequestDispatcher("./index.jsp").forward(request, response);
	} else {
		response.sendRedirect("./Login.jsp");
	}
%>

</body>
</html>