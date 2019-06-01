<%@page import="com.news.util.PageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.news.pojo.News"%>
<%@page import="java.util.List"%>
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
		//获取当前页码
		String sPageIndex =	request.getParameter("pageIndex");
		Integer pageIndex = 1;
		if(sPageIndex == null || "".equals(sPageIndex)){
			pageIndex = 1;
		}else{
			pageIndex = Integer.valueOf(sPageIndex);
		}
	
		//获得总数据量
		Integer count = newsService.getNewsCount();
		//设置每页容量
		Integer pageSize = 3;
		//获得总页数
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCount(count);
		pageUtil.setPageSize(pageSize);
		pageUtil.setPageIndex(pageIndex);
		pageUtil.setPageCount();
		
		Integer pageCount = pageUtil.getPageCount();
		
		if(pageIndex > pageCount){
			pageIndex = pageCount;
		}
		
		if(pageIndex < 1){
			pageIndex = 1;
		}
		//调用分页方法
		List<News> list = new ArrayList<News>();
		list = newsService.getNewsByPage(pageIndex, pageSize);
	%>
		<a href="add.jsp">点击添加新闻</a>
		<table border="1">
			<tr>
				<th>编号</th>
				<th>标题</th>
				<th>作者</th>
				<th>新闻类型</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
		<%
			for(News news:list){
		%>
			<tr>
				<td><%=news.getId()%></td>
				<td><a href="showNews.jsp?id=<%=news.getId()%>"><%=news.getTitle()%></a></td>
				<td><%=news.getAuthor()%></td>
				<td><%=news.getType()%></td>
				<td><a href="delete.jsp?id=<%=news.getId()%>">删除</a></td>
				<td><a href="edit.jsp?id=<%=news.getId()%>">修改</a></td>
			</tr>
		<%
			}
		%>
		</table>
		
		共有<%=count%>条数据；当前 <%=pageIndex%>/<%=pageCount%>页
		<%if(pageIndex > 1){ %>
			<a href="index.jsp?pageIndex=1">首页</a>
			<a href="index.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>
		<%}%>
		<%if(pageIndex < pageCount){ %>
			<a href="index.jsp?pageIndex=<%=pageIndex + 1%>">下一页</a>
			<a href="index.jsp?pageIndex=<%=pageCount%>">末页</a>
		<%}%>
		<form action="index.jsp">
			<input type="number" name="pageIndex" size="2px"/>
			<input type="submit" value="跳转"/>
		</form>
	</body>
</html>