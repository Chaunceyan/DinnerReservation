package com.order.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.order.bean.Customers;
import com.order.bean.Orders;
import com.order.dao.subsystem.CustomersDAO;
import com.order.dao.subsystem.OrdersDAO;

public class Test extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json,charset=UTF-8");
/*		HttpSession requestSession= request.getSession();
		Customers customer =  (Customers) requestSession.getAttribute("customer");*/
		Customers cus = new CustomersDAO().findById(1);
		OrdersDAO orderDao = new OrdersDAO();
		@SuppressWarnings("unchecked")
		List<Orders> ordersList = orderDao.findByProperty("customers",cus);
		System.out.println(ordersList.toString());
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JsonConfig jcfg = new JsonConfig();
		jcfg.setExcludes(new String[]{"customers","orderdetailses"});
		try {
			json.put("name","xiaoming");
			json.put("color", "red");
			jsonArray.addAll(ordersList,jcfg);
			json.put("orderlist",jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print(json);
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);

	}

}
