package com.order.servlet.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Orderdetails;
import com.order.dao.subsystem.OrderdetailsDAO;
import com.order.dao.subsystem.OrdersDAO;

public class ShowOrderDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ShowOrderDetailServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("orderid");
		OrderdetailsDAO orderDetailDao = new OrderdetailsDAO();
		@SuppressWarnings("unchecked")
		//List<Orders> ordersList = orderDao.findByProperty("CustomerID",customer.getCustomerId());
		List<Orderdetails> orderDetailsList = orderDetailDao.findByProperty("orders",new OrdersDAO().findById(Integer.valueOf(id)));
		System.out.println(orderDetailsList.size());
		request.setAttribute("orderdetaillist",orderDetailsList);
		request.getRequestDispatcher("../orderDetail.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	public void init() throws ServletException {
	}

}
