package com.order.servlet.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.order.bean.Customers;
import com.order.bll.RegisterBiz;
import com.order.bll.SignInBiz;

public class AndroidRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html,charset=UTF-8");
		BufferedReader in=new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = in.readLine();
		JsonParser parser = new JsonParser();
		JsonObject o = (JsonObject)parser.parse(line);
		System.out.println();o.get("username");
		
		String username = o.get("username").getAsString();
		String password = o.get("password").getAsString();
		String address = o.get("address").getAsString();
		String email = o.get("email").getAsString();
		String phoneNum = o.get("phoneNum").getAsString();
		SignInBiz sib = new SignInBiz();
		String validJson = "{ result: 'Valid'";
		String invalidJson = "{ result: 'Invalid'}";
		
		//System.out.println(request.);
		
		Customers customer = new Customers();
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setCustomerPhone(phoneNum);
		customer.setPassword(password);
		customer.setUserName(username);
		customer.setRegisterDate(new Date());
		customer.setTotalCost(0);
		
		try {
			RegisterBiz rb = new RegisterBiz();
			rb.addCustomer(customer);
			response.setContentType("application/json");
			// Get the printwriter object from response to write the required
			// json object to the output stream
			PrintWriter out = response.getWriter();
			//return JSON object
			int customerId = new SignInBiz().check(customer.getUserName(), customer.getPassword());
			validJson = validJson.concat(", customerId : '" + String.valueOf(customerId) + "'}");
			System.out.println(validJson);
			out.print(validJson);
			out.flush();
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			//return invalid Json
			out.print(invalidJson);
			out.flush();
		}
	}
}
