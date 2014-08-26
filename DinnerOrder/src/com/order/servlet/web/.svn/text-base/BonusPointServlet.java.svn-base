package com.order.servlet.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Orders;
import com.order.dao.subsystem.BonuspointsDAO;
import com.order.dao.subsystem.CustomersDAO;

public class BonusPointServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BonusPointServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		@SuppressWarnings("unchecked")
		//´Ë´¦Ìí¼Óid
		List<Orders> pointsList = new BonuspointsDAO().findByProperty("customers",new CustomersDAO().findById(1));
		request.setAttribute("pointslist",pointsList);
		request.getRequestDispatcher("../showPoints.jsp").forward(
				request, response);
	}

	public void init() throws ServletException {
	}

}
