package com.order.servlet.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Cart;
import com.order.bean.CartItem;
import com.order.bean.Customers;
import com.order.bean.Orderdetails;
import com.order.bean.Orders;
import com.order.dao.subsystem.CustomersDAO;
import com.order.dao.subsystem.OrderdetailsDAO;
import com.order.dao.subsystem.OrdersDAO;

/**
 * This class just simple modify the database,rather than truely dispatch the
 * dinner
 * 
 * @author administ
 * 
 */
public class PayServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String paymethod = request.getParameter("paymethod");
		String receivename = request.getParameter("receiveman");
		String receiveaddress = request.getParameter("receiveaddress");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Customers customer = (Customers) request.getSession().getAttribute(
				"customer");
		if(customer==null){
			request.getSession().setAttribute("sign", "尚未登录");
			request.getRequestDispatcher("../transform.jsp").forward(request, response);
			return;
		}
		System.out.println(customer.getAddress()+"aaaaa"+cart.getPrice());
		CustomersDAO customerDao = new CustomersDAO();
		
		// 增加用户的总消费额
		customerDao.updateTotalCost(cart.getPrice(), customer);
		// 增加订单表项目
		OrdersDAO ordersDao = new OrdersDAO();
		Orders order = new Orders();
		order.setCustomers(customer);
		order.setOrderTime(Calendar.getInstance().getTime());
		order.setTotalMoney(50);
		order.setDeliverTime(Calendar.getInstance().getTime());
		order.setConsigneeName(receivename);
		order.setConsigneeAddress(receiveaddress);
		order.setStatus("waiting");
		order.setPayMethod(paymethod);
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
		request.getSession().setAttribute("sign", "购买");
		request.getRequestDispatcher("../transform.jsp").forward(request, response);
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
