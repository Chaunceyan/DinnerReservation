<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body background="images\body_bg.jpg">
  <img src="images\header_bg.jpg">
  <br>
  <br>
  	<center>
		<h1>订单详情</h1>
	
	<table border="5">
		<tr>
			<td><img src="images/logo.png" height="60" /></td>
			<td>餐品名称</td>
			<td>餐品总价格</td>
			<td>餐品数量</td>
		</tr>

		<c:forEach var="orderdetail" items="${requestScope.orderdetaillist}">
			<tr>
				<!-- 此图片连接到订单那详情页面 -->
				<td><a href="servlet/ShowOrderDetailServlet?orderid=${orderdetail.orderDetailId}"><img
						src="images/logo.png" height="60" /> </a></td>
				<td><c:out value="${orderdetail.products.productsName}"></c:out></td>
				<td><c:out value="${orderdetail.price}"></c:out>
				</td>
				<td><c:out value="${orderdetail.quantity}"></c:out>
				</td>
			</tr>
		</c:forEach>
	</table>
</center>
  </body>
</html>
