<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<table border="5">
		<tr>
			<td><img src="images/logo.png" height="60" />
			</td>
			<td>餐厅名称</td>
			<td>餐厅地址</td>
			<td>餐厅电话</td>
			<td>餐厅类型</td>
			<td>积分总额</td>
		</tr>
		<c:forEach var="points" items="${requestScope.pointslist}">
			<tr>
				<!-- 此图片连接到订单那详情页面 -->
				<td><a href="a"><img src="images/logo.png" height="60" />
				</a>
				</td>
				<td><c:out value="${points.restaurant.resName}"></c:out>
				</td>
				<td><c:out value="${points.restaurant.resAddress}"></c:out>
				</td>
				<td><c:out value="${points.restaurant.resPhone}"></c:out>
				</td>
				<td><c:out value="${points.restaurant.resType}"></c:out>
				</td>
				<td><c:out value="${points.pointsCount}"></c:out>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
