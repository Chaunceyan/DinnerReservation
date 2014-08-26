<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'pay.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body background="images\body_bg.jpg">
	<img src="images\header_bg.jpg">
	<br>
	<br>
	<center>
		<h1>请选择您的付款方式</h1>
	</center>




	<form action="servlet/PayServlet" method="post">
		<p>
		<input type="radio" value="bankcard" name="paymethod" checked>通过银行卡付款
	</p>
	<p>
		<input type="radio" value="baby" name="paymethod">通过支付宝付款
	</p>
	<p>
		<input type="radio" value="cashondeliver" name="paythod">货到付款
	</p>
		请填写收货人:<br>
		<input type="text" name="receiveman" value="收货人"> <br>
		请填写收货地址:<br>
		<input type="text" name="receiveaddress" value="收货地点"><br> 
		<input type="submit" name="submit" value="确认付款"><br>
	</form>

	<img src="images\payment.png"
		style="position:absolute; bottom:0px; left:500px; ">
	<img src="images\secure.png"
		style="position:absolute; bottom:0px; left:350px;">
	<div
		style="width:100px; height:100px; position:fixed; bottom:10px; left:0px;">

	</div>








</body>
</html>
