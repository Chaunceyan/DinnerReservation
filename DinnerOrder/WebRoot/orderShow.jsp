<%@ page language="java" import="java.util.*,com.order.bean.Orders"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'order.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<!--  传入的order的list名字为orderlist,范围session-->
<body background="images\body_bg.jpg">
<img src="images\header_bg.jpg">
<br>
<br>
  	<center>
		<h1>您所有订单如下</h1>
	<table border="5" bordercolor="green">
		<tr>
			<td><img src="images/logo.png" height="60" /></td>
			<td>订餐时间</td>
			<td>订单总价</td>
			<td>配送时间</td>
			<td>收货姓名</td>
			<td>收货地址</td>
			<td>当前状态</td>
			<td>支付方式</td>
		</tr>

		<c:forEach var="order" items="${requestScope.orderlist}">
			<tr>
				<!-- 此图片连接到订单那详情页面 -->
				<td><a href="servlet/ShowOrderDetailServlet?orderid=${order.orderId}"><img
						src="images/logo.png" height="60" /> </a></td>
				<td><c:out value="${order.orderTime}"></c:out></td>
				<td><c:out value="${order.totalMoney}"></c:out>
				</td>
				<td><c:out value="${order.deliverTime}"></c:out>
				</td>
				<td><c:out value="${order.consigneeName}"></c:out>
				</td>
				<td><c:out value="${order.consigneeAddress}"></c:out>
				</td>
				<td><c:out value="${order.status}"></c:out>
				</td>
				<td><c:out value="${order.payMethod}"></c:out>
				</td>
			</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>
