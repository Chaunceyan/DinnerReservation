package com.order.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.order.bean.Customers;
import com.order.dao.subsystem.CustomersDAO;

public class ShowCustomerInfoServlet extends HttpServlet {


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json,charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int customerid = Integer.valueOf(request.getParameter("customerid"));
		System.out.println(customerid);
		CustomersDAO customerDao = new CustomersDAO();
		Customers customer = customerDao.findById(customerid);
		JsonConfig cfg = new JsonConfig();
		JSONObject json = new JSONObject();
		JsonValueProcessor jvp = new JsonValueProcessor() {

			@Override
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				return null;
			}

			@Override
			public Object processObjectValue(String arg0, Object arg1,
					JsonConfig arg2) {
				if (arg1 instanceof Date) {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

					return df.format((Date) arg1);
				}
				return null;
			}

		};
		
		cfg.registerJsonValueProcessor(Date.class, jvp);
		cfg.setExcludes(new String[] { "orderses","bonuspointses" });
		json = JSONObject.fromObject(customer,cfg);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.print(URLEncoder.encode(json.toString(), "utf-8"));
		out.flush();
		out.close();
	}


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
