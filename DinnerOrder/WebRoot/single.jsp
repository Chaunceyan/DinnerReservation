<%@ page language="java"
	import="java.util.*,com.order.dao.subsystem.ProductsDAO"
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
<title>Single</title>
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
<link
	href='http://fonts.googleapis.com/css?family=Exo+2:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<!----details-product-slider--->
<!-- Include the Etalage files -->
<link rel="stylesheet" href="css/etalage.css">
<script src="js/jquery.etalage.min.js"></script>
<!-- Include the Etalage files -->
<script>
	jQuery(document)
			.ready(
					function($) {

						$('#etalage')
								.etalage(
										{
											thumb_image_width : 300,
											thumb_image_height : 400,

											show_hint : true,
											click_callback : function(
													image_anchor, instance_id) {
												alert('Callback example:\nYou clicked on an image with the anchor: "'
														+ image_anchor
														+ '"\n(in Etalage instance: "'
														+ instance_id + '")');
											}
										});
						// This is for the dropdown list example:
						$('.dropdownlist').change(
								function() {
									etalage_show($(this)
											.find('option:selected').attr(
													'class'));
								});

					});
</script>

<!----//details-product-slider--->
</head>
<body>


	<%
		int id = Integer.valueOf(request.getParameter("singleToShowID"));
		System.out.println(id);
		request.setAttribute("singleToShow",new ProductsDAO().findById(id));
	%> 

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
					<li><a href=""> <i class="tw"> </i> </a>
					</li>
					<li><a href=""><i class="fb"> </i> </a>
					</li>
					<li><a href=""><i class="rss"> </i> </a>
					</li>
					<li><a href=""><i class="msg"> </i> </a>
					</li>
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
								class="img-responsive" alt="" />
							</a>
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
									<li class="active"><a href="index.html">Specials</a>
									</li>
									<li><a href="fruits.html">Fruits & Veg</a>
									</li>
									<li><a href="products.html">Food Products</a>
									</li>
									<li><a href="store.html">Locate Store</a>
									</li>
									<li><a href="club.html">Fan Club</a>
									</li>
									<li><a href="contact.html">Contact</a>
									</li>
								</ul>
								<ul class="login">
									<a href="account.jsp"><li class="login_top"><i
											class="sign"> </i><span>Sign In</span>
									</li>
									</a>
									<a href="register.jsp"><li class="login_bottom"><i
											class="register"> </i><span>Register</span>
									</li>
									</a>
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
			<div class="single">
				<div class="row content">
					<div class="col-md-3">
						<div class="category_box">
							<h3 class="cate_head">Categories</h3>
							<ul class="category">
								<li><a href="#">Arts</a>
								</li>
								<li><a href="#">Beauty</a>
								</li>
								<li><a href="#">Books</a>
								</li>
								<li><a href="#">Cart Software</a>
								</li>
								<li><a href="#">Electronics</a>
								</li>
								<li><a href="#">Fashion / Clothing</a>
								</li>
								<li><a href="#">Food</a>
								</li>
								<li><a href="#">Furniture</a>
								</li>
								<li><a href="#">Home Goods</a>
								</li>
								<li><a href="#">Jewelry</a>
								</li>
								<li><a href="#">Lingerie</a>
								</li>
								<li><a href="#">Music</a>
								</li>
								<li><a href="#">Office Supplies</a>
								</li>
								<li><a href="#">Printing</a>
								</li>
								<li><a href="#">Software</a>
								</li>
							</ul>
						</div>
						<ul class="product_reviews">
							<h3>
								<i class="arrow"> </i><span>Product Reviews</span>
							</h3>
							<li>
								<ul class="review1">
									<li class="review1_img"><img src="images/pic1.jpg"
										class="img-responsive" alt="" />
									</li>
									<li class="review1_desc"><h3>
											<a href="#">Lorem ipsum dolor sit amet, consectetuer
												adipiscing elit</a>
										</h3>
										<p>Wed, June 2014</p>
									</li>
									<div class="clearfix"></div>
								</ul></li>
							<li>
								<ul class="review1">
									<li class="review1_img"><img src="images/pic2.jpg"
										class="img-responsive" alt="" />
									</li>
									<li class="review1_desc"><h3>
											<a href="#">Lorem ipsum dolor sit amet, consectetuer
												adipiscing elit</a>
										</h3>
										<p>Wed, June 2014</p>
									</li>
									<div class="clearfix"></div>
								</ul></li>
							<li>
								<ul class="review1">
									<li class="review1_img"><img src="images/pic3.jpg"
										class="img-responsive" alt="" />
									</li>
									<li class="review1_desc"><h3>
											<a href="#">Lorem ipsum dolor sit amet, consectetuer
												adipiscing elit</a>
										</h3>
										<p>Wed, June 2014</p>
									</li>
									<div class="clearfix"></div>
								</ul></li>
							<div class="but">
								<a href="#">More Reviews<i class="but_arrow"> </i>
								</a>
							</div>
						</ul>

						<ul class="product_reviews">
							<h3>
								<i class="arrow"> </i><span>Payment Methods</span>
							</h3>
							<img src="images/payment.png" class="img-responsive" alt="" />
						</ul>
					</div>
					<div class="col-md-9">
						<div class="single_image">
							<ul id="etalage">
								<li><a href="optionallink.html"> <img
										class="etalage_thumb_image" src="${singleToShow.productPicture}"
										class="img-responsive" alt="" /> <img
										class="etalage_source_image" src="${singleToShow.productPicture}"
										class="img-responsive" alt="" /> </a></li>
								<li><img class="etalage_thumb_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /> <img
									class="etalage_source_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /></li>
								<li><img class="etalage_thumb_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /> <img
									class="etalage_source_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /></li>
								<li><img class="etalage_thumb_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /> <img
									class="etalage_source_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /></li>
								<li><img class="etalage_thumb_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /> <img
									class="etalage_source_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /></li>
								<li><img class="etalage_thumb_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /> <img
									class="etalage_source_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /></li>
								<li><img class="etalage_thumb_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /> <img
									class="etalage_source_image" src="${singleToShow.productPicture}"
									class="img-responsive" alt="" /></li>
							</ul>
						</div>
						<div class="single_right">
							<h3>${singleToShow.productsName}</h3>
							<p class="m_5">限时打折<br>开始时间：&nbsp${singleToShow.discountStartTime}<br>截止时间：&nbsp${singleToShow.discountEndTime}</p>
							<div class="price_single">
								<span class="reducedfrom">${singleToShow.productsPrice}</span> <span class="actual1">${singleToShow.productsPrice*singleToShow.productsDiscount/100}</span>
								${singleToShow.productsDiscount/10}折
							</div>

							<div class="btn_form">
								<form action="servlet/BuyNowServlet?products=${singleToShow.productsId}&signal=settle" method="post">
									<input type="submit" value="购买并结算" name="buynow">
								</form>
							</div>
						<div class="btn_form">
								<form action="servlet/BuyNowServlet?products=${singleToShow.productsId}&signal=continue" method="post">
									<input type="submit" value="购买并继续购物" name="buynow">
								</form>
							</div>
							<ul class="add-to-links">
								<li><img src="images/wish.png" alt=""><a href="#">Add
										to wishlist</a>
								</li>
							</ul>
							<div class="col-xs-12  col-sm-6  col-md-4">
								<div class="banners--small  banners--small--social">
									<a href="#" class="social"><i class="zocial-facebook">
									</i> <span class="banners--small--text"> Share on<br>Facebook</span>
										<div class="clearfix"></div> </a>
								</div>
							</div>
							<div class="col-xs-12  col-sm-6  col-md-4">
								<div class="banners--small  banners--small--social">
									<a href="#" class="social"><i class="zocial-twitter"> </i>
										<span class="banners--small--text"> Tweet it<br>Twitter</span>
										<div class="clearfix"></div> </a>
								</div>
							</div>
							<div class="col-xs-12  col-sm-6  col-md-4">
								<div class="banners--small  banners--small--social">
									<a href="#" class="social"><i class="zocial-pin"> </i> <span
										class="banners--small--text">Pin on<br>Pinterest</span>
										<div class="clearfix"></div> </a>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
						<!----product-rewies---->
						<div class="product-reviwes">
							<!--vertical Tabs-script-->
							<!---responsive-tabs---->
							<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
							<script type="text/javascript">
								$(document).ready(function() {
									$('#horizontalTab').easyResponsiveTabs({
										type : 'default', //Types: default, vertical, accordion           
										width : 'auto', //auto or any width like 600px
										fit : true, // 100% fit in a container
										closed : 'accordion', // Start closed if in accordion view
										activate : function(event) { // Callback function if tab is switched
											var $tab = $(this);
											var $info = $('#tabInfo');
											var $name = $('span', $info);
											$name.text($tab.text());
											$info.show();
										}
									});

									$('#verticalTab').easyResponsiveTabs({
										type : 'vertical',
										width : 'auto',
										fit : true
									});
								});
							</script>
							<!---//responsive-tabs---->
							<!--//vertical Tabs-script-->
							<!--vertical Tabs-->
							<div id="verticalTab">
								<ul class="resp-tabs-list">
									<li>描述</li>
									<li>打折提醒</li>
									
								</ul>
								<div class="resp-tabs-container vertical-tabs">
									<div>
										<h3>描述</h3>
										<p>${singleToShow.productsDescription}</p>
									</div>
									<div>
										<h3>打折提醒</h3>
										<p class="m_5">开始时间:&nbsp${singleToShow.discountStartTime}<br>截止时间：&nbsp${singleToShow.discountEndTime}</p>
										<p class="m_5">为您节省:&nbsp${singleToShow.productsPrice*(1-singleToShow.productsDiscount/100)}</p>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="related_products">
							<h3>Related Products</h3>
							<div class="row">
								<div class="col-md-4 related">
									<img src="images/pic4.jpg" class="img-responsive" alt="" />
								</div>
								<div class="col-md-4 related">
									<img src="images/pic5.jpg" class="img-responsive" alt="" />
								</div>
								<div class="col-md-4">
									<img src="images/pic6.jpg" class="img-responsive" alt="" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="footer-grid footer-grid1">
				<h3 class="m_2">Company</h3>
				<ul class="list1">
					<li><a href="#">Home</a>
					</li>
					<li><a href="#">About Us</a>
					</li>
					<li><a href="#">Blog</a>
					</li>
					<li><a href="#">Latest News</a>
					</li>
					<li><a href="#">Login</a>
					</li>
					<li><a href="#">Join Us</a>
					</li>
				</ul>
			</div>
			<div class="footer-grid footer-grid2">
				<h3 class="m_2">Company</h3>
				<ul class="list1">
					<li><a href="#">Lorem ipsum dolor sit amet</a>
					</li>
					<li><a href="#">diam nonummy nibh euismod</a>
					</li>
					<li><a href="#">nostrud exerci tation</a>
					</li>
					<li><a href="#">hendrerit in vulputate velit</a>
					</li>
					<li><a href="#">soluta nobis eleifend option</a>
					</li>
					<li><a href="#">dynamicus, qui sequitur</a>
					</li>
				</ul>
			</div>
			<div class="footer-grid footer-grid3">
				<h3 class="m_2">Information</h3>
				<ul class="list1">
					<li><a href="#">My Account</a>
					</li>
					<li><a href="#">Rewards</a>
					</li>
					<li><a href="#">Terms & Conditions</a>
					</li>
					<li><a href="#">Buying Guide</a>
					</li>
					<li><a href="#">FAQ</a>
					</li>
				</ul>
			</div>
			<div class="footer-grid footer-grid4">
				<h3 class="m_2">Let's be friends</h3>
				<ul class="footer_social">
					<li><a href=""> <i class="tw"> </i> </a>
					</li>
					<li><a href=""><i class="fb"> </i> </a>
					</li>
					<li><a href=""><i class="rss"> </i> </a>
					</li>
					<li><a href=""><i class="msg"> </i> </a>
					</li>
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
