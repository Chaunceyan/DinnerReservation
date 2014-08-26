package com.order.servlet.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.bean.Customers;
import com.order.bean.Orders;
import com.order.dao.subsystem.OrdersDAO;

public class ShowOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowOrderServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession requestSession= request.getSession();
		Customers customer =  (Customers) requestSession.getAttribute("customer");
		OrdersDAO orderDao = new OrdersDAO();
		@SuppressWarnings("unchecked")
		List<Orders> ordersList = orderDao.findByProperty("customers",customer);
		//List<Orders> ordersList = orderDao.findByProperty("customers",new CustomersDAO().findById(1));
		request.setAttribute("orderlist",ordersList);
		request.getRequestDispatcher("../orderShow.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	public void init() throws ServletException {
	}

}
