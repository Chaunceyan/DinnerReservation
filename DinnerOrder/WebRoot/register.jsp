<%@page import="com.order.dao.subsystem.ProductsDAO,com.order.bean.Products"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>Register</title>
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
<link href='http://fonts.googleapis.com/css?family=Exo+2:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>

    <base href="<%=basePath%>">
    

    
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
<div class="header">
		<div class="container">
		  <div class="header_top">
			<ul class="phone">
				<li class="phone_left"><i class="mobile"> </i><span>1-200-346-2986</span></li>
				<li class="phone_right">Free Ground Shipping for Products over $100</li>
				<div class="clearfix"></div>
			</ul>
			<ul class="social">
				 <li><a href=""> <i class="tw"> </i> </a></li>
				 <li><a href=""><i class="fb"> </i> </a></li>
				 <li><a href=""><i class="rss"> </i> </a></li>
				 <li><a href=""><i class="msg"> </i> </a></li>
				 <div class="clearfix"> </div>
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
				<a href="index.html"><img src="images/logo.png" alt=""/><br></a>
			 </div>
			 <nav class="navbar navbar-default menu" role="navigation"><h3 class="nav_right"><a href="index.html"><img src="images/logo.png" class="img-responsive" alt=""/></a></h3>
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			    </div>
				<!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav menu1">
			      	<li class="active"><a href="index.html">Specials</a></li>
			        <li><a href="fruits.html">Fruits & Veg</a></li>
			        <li><a href="products.html">Food Products</a></li>
			        <li><a href="store.html">Locate Store</a></li>
			        <li><a href="club.html">Fan Club</a></li>
			        <li><a href="contact.html">Contact</a></li>
		          </ul>
		          <ul class="login">
		          	<a href="account.html"><li class="login_top"><i class="sign"> </i><span>Sign In</span></li></a>
		            <a href="register.html"><li class="login_bottom"><i class="register"> </i><span>Register</span></li></a>
		          </ul>
			      <div class="clearfix"></div>
			      </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
            <div class="clearfix"></div>
           </div>
            <div class="search">
			  <input type="text" class="text" value="Enter Product Details" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Product Details';}">
			  <input type="submit" value="Search">
			</div>
		 </div>  
		</div>
	</div>
    <div class="main">
		<div class="container">
		  <div class="Product_top">
		  	  <form action="servlet/RegisterServlet" method="post"> 
				 <div class="register-top-grid">
					<h3>PERSONAL INFORMATION</h3>
					 <div>
						<span>User Name<label>*</label></span>
						<input type="text" name="username"> 
					 </div>
					 <div>
						<span>Email<label>*</label></span>
						<input type="text" name="email"> 
					 </div>
					 <div>
						 <span>Address<label>*</label></span>
						 <input type="text" name="address"> 
					 </div>
					 <div> 
					   	 <span>Phone<label>*</label></span>
						 <input type="text" name="phone"> 
					</div>
					<div class="clearfix"> </div>
						<div class="register-bottom-grid">
							<h3>LOGIN INFORMATION</h3>
							 <div>
								<span>Password<label>*</label></span>
								<input type="text" name="password">
							 </div>
						
						  </div>
		<!-- 		</form>
				  <div class="clearfix"> </div> -->
<!-- 					<div class="register-but">
					   <form> -->
						 <input type="submit" value="submit">
						 <div class="clearfix"> </div>
						</form>
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
				 <div class="clearfix"> </div>
			   </ul>
			   <h3 class="m_3">Subscribe</h3>
			   <p class="m_4">aliquam erat volutpat. Ut wisi</p>
			   <div class="footer_search">
			    <input type="text" class="text" value="Enter Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Email';}">
			    <input type="submit" value="Search">
			   </div>
		   </div>
		   <div class="footer-grid footer-grid_last">
	          <ul class="secure">
			  	<li class="secure_img"><img src="images/secure.png" alt=""/></li> 
			  	<li class="secure_desc">Lorem ipsum dolor coadipiscing</li>
			  	<div class="clearfix"> </div>
			  </ul>
			  <ul class="secure">
			  	<li class="secure_img"><img src="images/order.png" alt=""/></li> 
			  	<li class="secure_desc">Lorem ipsum dolor coadipiscing</li>
			  	<div class="clearfix"> </div>
			 </ul>
		   </div>
		   <div class="clearfix"> </div>
		   <div class="copy">
		    <p>Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		</div>
	   </div>
	</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

  </body>
</html>


