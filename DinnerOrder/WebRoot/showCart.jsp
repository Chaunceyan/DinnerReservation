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
    
    <title>My JSP 'showCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
     <body style="text-align: center;" background="images\body_bg.jpg">
     <img src="images\header_bg.jpg">
  	<br>
    	<h1>您购买的商品如下</h1>
    	<c:if test="${empty sessionScope.cart.items}">
    		对不起！您还没有购买任何商品
    	</c:if>
    	<c:if test="${!empty sessionScope.cart.items}">
    		<table border="1" width="88%">
    			<tr>
					<th>图片</th>
 					<th>序号</th>
    				<th>菜名</th>
    				<th>现价</th>
    				<th>数量</th>
    				<th>小计</th>
    				<th>操作</th>
    			</tr>
    			<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
    				<tr bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3'}">
    					<td><img src=${me.value.products.productPicture} height="30" width="30"></td>
	    				<td>${vs.count}</td>
	    				<td>${me.value.products.productsName}</td>
	    				<td>${me.value.products.productsPrice*me.value.products.productsDiscount/100}</td>
	    				<td>
							<input type="text" name="num" value="${me.value.num}" size="3" onchange="changeNum(this,'${me.key}',${me.value.num})"/>
						</td>
	    				<td>${me.value.price}</td>
	    				<td>
	    					[<a href="javascript:delOne('${me.key}')">删除</a>]
	    				</td>
	    			</tr>
    			</c:forEach>
    			<tr>
	    			<td colspan="2">
	    				[<a href="javascript:delAll()">清空购物车</a>]
	    			</td>
	    			<td colspan="2" align="right">总计</td>
	    			<td colspan="2">${sessionScope.cart.price}</td>
	    		</tr>
    		</table>
    	</c:if>
    	
    	<a href="${pageContext.request.contextPath}">继续购物</a>
    	<a href="pay.jsp">结算</a>
    	<script type="text/javascript">
    		function changeNum(inputObj,bookId,oldNum){
				var newnum = inputObj.value;//新的数量
				var sure = window.confirm("确定要把数量改为"+newnum+"吗?");//返回值 ：点确定就返回true
				if(sure){
					//alert("提交服务器去处理");
					window.location.href="${pageContext.request.contextPath}/servlet/ChangeNumServlet?productId="+bookId+"&newnum="+newnum;
				}else{
					//改回原来的值
					inputObj.value=oldNum;
				}
    		}
    		//删除一个购物项
    		function delOne(bookId){
				var sure = window.confirm("确定要删除该项吗?");
				if(sure){
					window.location.href="${pageContext.request.contextPath}/servlet/DelOneCartItemServlet?bookId="+bookId;
				}
    		}
    		function delAll(){
    			var sure = window.confirm("确定要清空购物车吗?");
				if(sure){
					window.location.href="${pageContext.request.contextPath}/servlet/DelAllCartItemServlet";
				}
             }
    	</script>
    	${message }

  </body>
</html>
