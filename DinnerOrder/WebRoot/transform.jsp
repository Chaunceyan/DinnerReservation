<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'transform.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <img src="images\header_bg.jpg">
  <body background="images\body_bg.jpg">
    ${sessionScope.sign}成功，<a href="mainServlet">点击跳转主页</a>&nbsp&nbsp&nbsp&nbsp&nbsp<font size="3" color="red">网页将在1秒后自动跳转</font>
    
    <%
		response.setHeader("Refresh", "1;URL=../mainServlet");
	%>
  </body>
</html>
