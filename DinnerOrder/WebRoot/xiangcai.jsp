<%@ page language="java"
	import="java.util.*,com.order.bll.*,com.order.bean.*"
	pageEncoding="gbk"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>湘菜系列</title>
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
				<c:forEach items="${sessionScope.fourProducts}" var="product" begin="0" end="3">
					<div class="col-md-3">
						<div class="content_box">
							
								<div class="view view-fifth">
								<a href="single.jsp?singleToShowID=${product.productsId}">
									<img src="${product.productPicture}" class="img-responsive"
										alt="" /></a>
									<div class="content_box-grid">
										<p class="m_1">
											<c:out value="${product.productsDescription }"
												escapeXml="true"></c:out>
										</p>
										<div class="price">
											Price: <span class="actual">$<c:out
													value="${product.productsPrice}" escapeXml="true"></c:out>
											</span>

										</div>
										<ul class="product_but">
											<li class="but3" ><a href="servlet/BuyNowServlet?products=${product.productsId}&signal=settle">Buy</a></li>
											<li class="like"><span>120</span><i class="like1"> </i>
											</li>
											<div class="clearfix"></div>
										</ul>
										<div class="mask">
											<div class="info">Quick View</div>
										</div>
									</div>
								</div> 
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="row content_bottom1">
				<c:forEach items="${sessionScope.fourProducts}" var="product"
					begin="4" end="7">
					<div class="col-md-3">
						<div class="content_box">
							
								<div class="view view-fifth">
								<a href="single.jsp?singleToShowID=${product.productsId}">
									<img src="${product.productPicture}" class="img-responsive"
										alt="" /></a>
									<div class="content_box-grid">
										<p class="m_1">
											<c:out value="${product.productsDescription }"
												escapeXml="true"></c:out>
										</p>
										<div class="price">
											Price: <span class="actual">$<c:out
													value="${product.productsPrice}" escapeXml="true"></c:out>
											</span>
										</div>
										<ul class="product_but">
											<li class="but3" ><a href="servlet/BuyNowServlet?products=${proDiscount.productsId}&signal=settle">Buy</a></li>
											<li class="like"><span>120</span><i class="like1"> </i>
											</li>
											<div class="clearfix"></div>
										</ul>
										<div class="mask">
											<div class="info">Quick View</div>
										</div>
									</div>
								</div> 
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<c:set value="${sessionScope.pageIndex}" var="pageIndex"></c:set>
		<a href="servlet/ShowVegServlet?type=xiangcai&pageIndex=1">首页</a> <a
			href="servlet/ShowVegServlet?type=xiangcai&pageIndex=${pageIndex-1}">上一页</a>
		<a
			href="servlet/ShowVegServlet?type=xiangcai&pageIndex=${pageIndex+1}">下一页</a>
		<a
			href="servlet/ShowVegServlet?type=xiangcai&pageIndex=${sessionScope.lastPage}">尾页</a>
		<a href="mainServlet">主页</a>
</body>
</html>
