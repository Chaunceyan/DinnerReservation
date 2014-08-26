package com.order.servlet.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Customers;
import com.order.bll.RegisterBiz;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		Customers customer = new Customers();
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setCustomerPhone(phone);
		customer.setPassword(password);
		customer.setUserName(username);
		customer.setRegisterDate(new Date());
		customer.setTotalCost(0);
		RegisterBiz rb = new RegisterBiz();
		rb.addCustomer(customer);
		request.getSession().setAttribute("customer", customer);
		request.getSession().setAttribute("sign", "зЂВс");
		request.getRequestDispatcher("../transform.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
