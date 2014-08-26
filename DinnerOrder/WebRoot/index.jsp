<%@ page language="java"
	import="java.util.*,com.order.bll.*,com.order.bean.*"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
<!----webfonts---->
<!---<link href='http://fonts.googleapis.com/css?family=Exo+2:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>--->
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="header_top">
				<ul class="phone">
					<li class="phone_left"><i class="mobile"> </i><span>1-200-346-2986</span>
					</li>
					<li class="phone_right">Free Ground Shipping for Products over
						$100</li>
					<div class="clearfix"></div>
				</ul>
				<ul class="social">
					<li><a href=""> <i class="tw"> </i> </a></li>
					<li><a href=""><i class="fb"> </i> </a></li>
					<li><a href=""><i class="rss"> </i> </a></li>
					<li><a href=""><i class="msg"> </i> </a></li>
					<div class="clearfix"></div>
				</ul>

				<ul class="order">
					<c:choose>
						<c:when test="${sessionScope.isSignIn}">
							<li><a href="servlet/ShowOrderServlet">我的订单</a>
							</li>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</ul>


				<ul class="order">
					<c:choose>
						<c:when test="${sessionScope.isSignIn}">
							<li>欢迎 <c:out value="${sessionScope.customer.userName}"></c:out></li>
						</c:when>
						<c:otherwise>
							<li>尚未登录</li>
						</c:otherwise>
					</c:choose>
				</ul>

				<ul class="shopping_cart">
					<a href="showCart.jsp"><li class="shop_left"><i class="cart"> </i><span>Shop</span>
					</li> </a>
					<li class="shop_right"><span>￥${sessionScope.cart.price}</span></li> 
					<div class="clearfix"></div>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="header_bottom">
				<div class="header_nav">
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt="" /><br>
						</a>
					</div>
					<nav class="navbar navbar-default menu" role="navigation">
						<h3 class="nav_right">
							<a href="index.html"><img src="images/logo.png"
								class="img-responsive" alt="" /> </a>
						</h3>
						<div class="container-fluid">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle"
									data-toggle="collapse"
									data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
							</div>
							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse"
								id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav menu1">
									<li class="active"><a href="index.html">Specials</a></li>
									<li><a href="fruits.html">Fruits & Veg</a></li>
									<li><a href="products.html">Food Products</a></li>
									<li><a href="store.html">Locate Store</a></li>
									<li><a href="club.html">Fan Club</a></li>
									<li><a href="contact.html">Contact</a></li>
								</ul>
								<ul class="login">
									<a href="account.jsp"><li class="login_top"><i
											class="sign"> </i><span>Sign In</span></li> </a>
									<a href="register.jsp"><li class="login_bottom"><i
											class="register"> </i><span>Register</span></li> </a>
								<a href="servlet/SignOutServlet"><li class="login_top"><i
											class="sign"> </i><span>Sign out</span></li> </a>
								</ul>
								<div class="clearfix"></div>
							</div>
							<!-- /.navbar-collapse -->
						</div>
						<!-- /.container-fluid -->
					</nav>
					<div class="clearfix"></div>
				</div>
				<div class="search">
					<input type="text" class="text" value="Enter Product Details"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Enter Product Details';}">
					<input type="submit" value="Search">
				</div>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="container">
			<div class="banner">
				<img src="images/banner.jpg" class="img-responsive" alt="" />
			</div>
			<div class="row content">
				<div class="col-md-3 content_top">
					<div class="category_box">
						<h3 class="cate_head">种类</h3>
						<ul class="category">
							<li><a href="servlet/ShowVegServlet?pageIndex=1&type=chuancai">川菜</a></li>
			   	  	        <li><a href="servlet/ShowVegServlet?pageIndex=1&type=yuecai">粤菜</a></li>
			   	  	        <li><a href="servlet/ShowVegServlet?pageIndex=1&type=huicai">徽菜</a></li>
			   	  	        <li><a href="servlet/ShowVegServlet?pageIndex=1&type=xiangcai">湘菜</a></li>
			   	  	        <li><a href="servlet/ShowVegServlet?pageIndex=1&type=xican">西餐</a></li>
						</ul>
					</div>
					<ul class="product_reviews">
						<h3>
							<i class="arrow"> </i><span>Product Reviews</span>
						</h3>
						<li>
							<ul class="review1">
								<li class="review1_img"><img src="images/pic1.jpg"
									class="img-responsive" alt="" /></li>
								<li class="review1_desc"><h3>
										<a href="#">Lorem ipsum dolor sit amet, consectetuer
											adipiscing elit</a>
									</h3>
									<p>Wed, June 2014</p></li>
								<div class="clearfix"></div>
							</ul>
						</li>
						<li>
							<ul class="review1">
								<li class="review1_img"><img src="images/pic2.jpg"
									class="img-responsive" alt="" /></li>
								<li class="review1_desc"><h3>
										<a href="#">Lorem ipsum dolor sit amet, consectetuer
											adipiscing elit</a>
									</h3>
									<p>Wed, June 2014</p></li>
								<div class="clearfix"></div>
							</ul>
						</li>
						<li>
							<ul class="review1">
								<li class="review1_img"><img src="images/pic3.jpg"
									class="img-responsive" alt="" /></li>
								<li class="review1_desc"><h3>
										<a href="#">Lorem ipsum dolor sit amet, consectetuer
											adipiscing elit</a>
									</h3>
									<p>Wed, June 2014</p></li>
								<div class="clearfix"></div>
							</ul>
						</li>
						<div class="but">
							<a href="#">More Reviews<i class="but_arrow"> </i> </a>
						</div>
					</ul>

					<ul class="product_reviews">
						<h3>
							<i class="arrow"> </i><span>Payment Methods</span>
						</h3>
						<img src="images/payment.png" class="img-responsive"
							alt="images/payment.png" />
					</ul>
				</div>
				<div class="col-md-9">
					<ul class="feature">
						<h3>
							<i class="arrow"> </i><span><a href="mainServlet?action=discount">Today's Featured Products</a></span>
						</h3>
					</ul>


					<ul class="feature_grid">
					<c:forEach items="${requestScope.listDiscount}" var="proDiscount">
								
						<li  class="grid1">
						<a href="single.jsp?singleToShowID=${proDiscount.productsId}">		
						<img src=${proDiscount.productPicture} height="30"
							class="img-responsive" alt="" />
							</a>
							<p>${proDiscount.productsDescription }</p>
							<div class="price">
								Price: <span class="actual">${proDiscount.productsPrice * proDiscount.productsDiscount / 100}</span>
							</div>
							<div class="but1">
								<a href="servlet/BuyNowServlet?products=${proDiscount.productsId}&signal=settle">Buy Now</a>
							</div>
						</li>	
										
						</c:forEach>
						
						
						<div class="clearfix"></div>
					</ul>
					<ul class="feature">
						<h3>
							<i class="arrow"> </i><span>Popular products</span>
						</h3>
					</ul>

					<div class="row content_bottom">
						<c:forEach items="${requestScope.listNotDiscount}" var="pro">
							<div class="col-md-3">
							
							
							
							
							
							
							
							
							
							
								<div class="content_box">
									
										<div class="view view-fifth">
										<a href="single.jsp?singleToShowID=${pro.productsId}">
											<img src=${pro.productPicture } class="img-responsive" alt="" />
											</a>
											<div class="content_box-grid">
												<p class="m_1">${pro.productsDescription }</p>
												<div class="price">
													Price: <span class="actual">${pro.productsPrice }</span>
												</div>
												<ul class="product_but">
													<li class="but3"><a href="servlet/BuyNowServlet?products=${pro.productsId}&signal=settle">Buy</a></li>
													<li class="like"><span>120</span><i class="like1">
													</i></li>
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
					<ul class="dc_pagination dc_paginationA dc_paginationA06">
						<c:set value="${requestScope.pageNum }"  var="pageNum" /> 
						<li><a href="mainServlet?pageNum=1">首页</a></li>
						<li><a href="mainServlet?pageNum=${pageNum-1 }"
							class="current">上一页</a></li>
						<li><a href="mainServlet?pageNum=${pageNum+1 }"
							class="previous">下一页</a></li>
						<li><a href="mainServlet?pageNum=${sessionScope.pageCount }" class="next">尾页</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="footer-grid footer-grid1">
				<h3 class="m_2">Company</h3>
				<ul class="list1">
					<li><a href="#">Home</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Latest News</a></li>
					<li><a href="#">Login</a></li>
					<li><a href="#">Join Us</a></li>
				</ul>
			</div>
			<div class="footer-grid footer-grid2">
				<h3 class="m_2">Company</h3>
				<ul class="list1">
					<li><a href="#">Lorem ipsum dolor sit amet</a></li>
					<li><a href="#">diam nonummy nibh euismod</a></li>
					<li><a href="#">nostrud exerci tation</a></li>
					<li><a href="#">hendrerit in vulputate velit</a></li>
					<li><a href="#">soluta nobis eleifend option</a></li>
					<li><a href="#">dynamicus, qui sequitur</a></li>
				</ul>
			</div>
			<div class="footer-grid footer-grid3">
				<h3 class="m_2">Information</h3>
				<ul class="list1">
					<li><a href="#">My Account</a></li>
					<li><a href="#">Rewards</a></li>
					<li><a href="#">Terms & Conditions</a></li>
					<li><a href="#">Buying Guide</a></li>
					<li><a href="#">FAQ</a></li>
				</ul>
			</div>
			<div class="footer-grid footer-grid4">
				<h3 class="m_2">Let's be friends</h3>
				<ul class="footer_social">
					<li><a href=""> <i class="tw"> </i> </a></li>
					<li><a href=""><i class="fb"> </i> </a></li>
					<li><a href=""><i class="rss"> </i> </a></li>
					<li><a href=""><i class="msg"> </i> </a></li>
					<div class="clearfix"></div>
				</ul>
				<h3 class="m_3">Subscribe</h3>
				<p class="m_4">aliquam erat volutpat. Ut wisi</p>
				<div class="footer_search">
					<input type="text" class="text" value="Enter Email"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Enter Email';}">
					<input type="submit" value="Search">
				</div>
			</div>
			<div class="footer-grid footer-grid_last">
				<ul class="secure">
					<li class="secure_img"><img src="images/secure.png" alt="" />
					</li>
					<li class="secure_desc">Lorem ipsum dolor coadipiscing</li>
					<div class="clearfix"></div>
				</ul>
				<ul class="secure">
					<li class="secure_img"><img src="images/order.png" alt="" />
					</li>
					<li class="secure_desc">Lorem ipsum dolor coadipiscing</li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="clearfix"></div>
			<div class="copy">
				<p>
					Copyright &copy; 2014.Company name All rights reserved.<a
						target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</p>
			</div>
		</div>
	</div>
	<div style="display:none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>

