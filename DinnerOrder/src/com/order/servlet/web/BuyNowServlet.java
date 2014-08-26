package com.order.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Cart;
import com.order.bean.Products;
import com.order.dao.subsystem.ProductsDAO;

public class BuyNowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		Integer productId = Integer.valueOf(request.getParameter("products"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Products product = new ProductsDAO().findById(productId);
		cart.addProducts2Cart(product);
		String signal = request.getParameter("signal");
		if(signal.equals("settle")){
			request.getRequestDispatcher("../showCart.jsp").forward(request, response);
		}else if(signal.equals("continue")){
			request.getSession().setAttribute("sign","正在返回主页");
			request.getRequestDispatcher("../transform.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	public void init() throws ServletException {
	}

}
