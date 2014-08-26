<%@ page language="java" import="java.util.*,com.order.bll.*,com.order.bean.*" pageEncoding="gbk"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>打折菜品</title>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div class="main">
	<div class="container">
    <div class="row content_bottom">
    <c:forEach items="${requestScope.listDiscount}" var="product">
			   	   <div class="col-md-3">
			   	   	<div class="content_box"><a href="single.html">
			   	   	  	<div class="view view-fifth">
			   	   	     <img src= ${product.productPicture } class="img-responsive" alt=""/>
				   	   	 <div class="content_box-grid">
				   	   	  <p class="m_1">${product.productsDescription }</p>
				   	   	  <div class="price">Price:
						    <span class="actual">${product.productsPrice * product.productsDiscount / 100}</span>
						    
						  </div>
						  <ul class="product_but">
						  	<li class="but3">Buy</li>
						  	<li class="like"><span>120</span><i class="like1"> </i></li>
						  	<div class="clearfix"> </div>
						  </ul>
						   <div class="mask">
	                         <div class="info">Quick View</div>
			               </div>
			             </div>
				   	   	</div>
			   	   	   </a>
			   	   	  </div>
			   	   </div>
    </c:forEach>
			   </div>
			   </div>
			   </div>
			   <c:set value="${requestScope.DiscountpageNum}" var="DiscountpageNum"></c:set>
			   <a href="mainServlet?action=discount&DiscountDiscountpageNum=1">首页</a>
			   <a href="mainServlet?action=discount&DiscountpageNum=${DiscountpageNum-1}">上一页</a>
			   <a href="mainServlet?action=discount&DiscountpageNum=${DiscountpageNum+1}">下一页</a>
			   <a href="mainServlet?action=discount&DiscountpageNum=${sessionScope.DiscountpageCount}">尾页</a>
			   <a href="mainServlet">主页</a>
  </body>
</html>
