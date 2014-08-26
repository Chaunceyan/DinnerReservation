package com.order.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Cart;

public class DelOneCartItemServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		Integer productId = Integer.valueOf(request.getParameter("bookId"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//Cart cart = new Cart();
		cart.getItems().remove(productId);
		response.sendRedirect("../showCart.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
