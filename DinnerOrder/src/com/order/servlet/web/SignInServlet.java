package com.order.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bll.SignInBiz;

public class SignInServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		SignInBiz sib = new SignInBiz();
		if(sib.check(username,password)!=-1){
			request.getSession().setAttribute("customer",SignInBiz.staticCustomer);
			request.getSession().setAttribute("sign", "µÇê‘");
			request.getRequestDispatcher("../transform.jsp").forward(request, response);
		}else{
			response.getWriter().print("µÇÂ½Ê§°Ü");
			response.sendRedirect("../account.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
