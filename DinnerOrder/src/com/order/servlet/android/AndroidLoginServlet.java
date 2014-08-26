package com.order.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.order.bll.SignInBiz;
/*
 * Android Login Servlet
 */
public class AndroidLoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Get Your JsonObject Ready
		response.setContentType("text/json,charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int customerId;
		
		String line = request.getParameter("logininfo");
		System.out.println(line);
		JsonParser parser = new JsonParser();
		JsonObject o = (JsonObject)parser.parse(line);
		System.out.println();o.get("username");
		
		//Get Data
		String username = o.get("username").getAsString();
		String password = o.get("password").getAsString();
		
		SignInBiz sib = new SignInBiz();
		//String validJson = "{ result: Valid";
		//String invalidJson = "{ result: Invalid}";
		customerId = sib.check(username,password);
		JSONObject jsono = new JSONObject();
		
		if(customerId != -1) {
			jsono.put("result","Valid");
			//
	        response.setContentType("application/json");
	     // Get the printwriter object from response to write the required json object to the output stream      
	        PrintWriter out = response.getWriter();
	     // valid Json
	        //validJson = validJson.concat(", customerId: " + customerId + "}" );
	        jsono.put("customerId",String.valueOf(customerId));
	      //  System.out.println(validJson);
	        out.print(jsono);
	        out.flush();
		}else{
			jsono.put("result","Invalid");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			//invalid Json  
			 // System.out.println(invalidJson);
			out.print(jsono);
			out.flush();
		}
	}
	
}
