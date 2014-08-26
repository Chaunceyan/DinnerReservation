package com.order.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.order.bean.Productcategories;
import com.order.bean.Products;
import com.order.bean.Restaurant;
import com.order.bll.VegBIZ;

public class showOrderServletAndroid extends HttpServlet {
	int count = 1;
	String type = "default";
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json,charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		type = request.getParameter("type");
		System.out.println(type);
		count = Integer.valueOf(request.getParameter("count"));
		System.out.println(count);
		type = parse(type);
		PrintWriter out = response.getWriter();
		VegBIZ veg = new VegBIZ();
		if (count > veg.getLastPage(type)) {
			count =  veg.getLastPage(type);
			out.print("no");
			out.flush();
			out.close();
			System.out.println("no");
			return;
		}
		List<Products> list = veg.getFourProduct(count,type);
		JSONArray jsonarray = new JSONArray();
		JsonConfig cfg = new JsonConfig();
		JsonValueProcessor jvp = new JsonValueProcessor() {

			@Override
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				return null;
			}

			@Override
			public Object processObjectValue(String arg0, Object arg1,
					JsonConfig arg2) {
				if (arg1 instanceof Restaurant) {
					return ((Restaurant) arg1).getRestaurantId();
				}
				if (arg1 instanceof Productcategories) {
					return ((Productcategories) arg1).getProductCategoriedId();
				}
				if (arg1 instanceof Date) {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

					return df.format((Date) arg1);
				}
				return null;
			}

		};
		cfg.registerJsonValueProcessor(Date.class, jvp);
		cfg.registerJsonValueProcessor(Restaurant.class, jvp);
		cfg.registerJsonValueProcessor(Productcategories.class, jvp);
		cfg.setExcludes(new String[] { "orderdetailses" });
		for (Products pro : list) {
			jsonarray.add(JSONObject.fromObject(pro, cfg));
		}
		System.out.println(jsonarray);
		out.print(URLEncoder.encode(jsonarray.toString(), "utf-8"));
		out.flush();
		out.close();

	}

	/**
	 * @param word
	 * @return
	 */
	private String parse(String word) {
		if (word.equals("chuan")) {
			return "´¨²Ë";
		} else if (word.equals("yue")) {
			return "ÔÁ²Ë";
		} else if (word.equals("hui")) {
			return "»Õ²Ë";
		} else if (word.equals("xiang")) {
			return "Ïæ²Ë";
		} else if(word.equals("westernfood")){
			return "Î÷²Í";
		}return "noone";
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
