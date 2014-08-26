package com.order.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.AndroidCart;
import com.order.bean.CartItem;
import com.order.bean.Customers;
import com.order.bean.Orderdetails;
import com.order.bean.Orders;
import com.order.dao.subsystem.CustomersDAO;
import com.order.dao.subsystem.OrderdetailsDAO;
import com.order.dao.subsystem.OrdersDAO;
import com.order.dao.subsystem.ProductsDAO;

/**
 * This class just simple modify the database,rather than truely dispatch the
 * dinner
 * 
 * @author administ
 * 
 */
public class PayServletAndroid extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json,charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String cusid = request.getParameter("customerid");
		String receivename = request.getParameter("receiveName");
		String receiveaddress = request.getParameter("receiveAddress");
		String payMethod = request.getParameter("paymethod");
		Map<Integer, Integer> lsss = new HashMap<Integer, Integer>();
		for (int i = 0;; i++) {
			String sign = request.getParameter(String.valueOf(i));
			if (sign == null) {
				break;
			} else {
				String[] signs = sign.split("%");
				int productid = Integer.valueOf(signs[0]);
				int num = Integer.valueOf(signs[1]);
				lsss.put(productid, num);
			}
		}
		System.out.println(cusid+" "+receivename+" " +receiveaddress+"   "+lsss.toString());
		ProductsDAO pdao = new ProductsDAO();

		AndroidCart cart = new AndroidCart();

		for (Map.Entry<Integer, Integer> entry : lsss.entrySet()) {
			CartItem item = new CartItem();
			item.setNum(entry.getValue());
			item.setProducts(pdao.findById(entry.getKey()));
			cart.getItems().put(entry.getKey(), item);
		}
		System.out.println(cart);
		/*
		 * JSONTokener jsonParser = new JSONTokener(jsonStr); JSONObject json
		 * =(JSONObject) jsonParser.nextValue(); int customerid =
		 * Integer.valueOf(json.getString("customerid")); int receiveName =
		 * Integer.valueOf(json.getString("receiveName")); int receiveAddress =
		 * Integer.valueOf(json.getString("receiveAddress")); Map<String,String>
		 * temp = new HashMap<String,String>(); for(json.)
		 */

		CustomersDAO customerDao = new CustomersDAO();
		Customers customer = customerDao.findById(Integer.valueOf(cusid));
		
		// 增加用户的总消费额
		customerDao.updateTotalCost(cart.getPrice(), customer);
		// 增加订单表项目
		OrdersDAO ordersDao = new OrdersDAO();
		Orders order = new Orders();
		order.setCustomers(customer);
		order.setOrderTime(Calendar.getInstance().getTime());
		order.setTotalMoney(cart.getPrice());
		order.setDeliverTime(Calendar.getInstance().getTime());
		order.setConsigneeName(receivename);
		order.setConsigneeAddress(receiveaddress);
		order.setStatus("waiting");
		//
		order.setPayMethod(payMethod);
		ordersDao.addOrder(order);
		// 增加orderdetail表象
		OrderdetailsDAO orderdetailDao = new OrderdetailsDAO();
		Map<Integer, CartItem> map = cart.getItems();
		Set<Map.Entry<Integer, CartItem>> set = map.entrySet();
		for (Map.Entry<Integer, CartItem> entry : set) {
			Orderdetails odetails = new Orderdetails();
			odetails.setOrders(order);
			odetails.setPrice(entry.getValue().getPrice());
			odetails.setProducts(entry.getValue().getProducts());
			odetails.setQuantity(entry.getValue().getNum());
			orderdetailDao.addOrderDetail(odetails);
		}
		PrintWriter out = response.getWriter();
		out.print("ok");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
