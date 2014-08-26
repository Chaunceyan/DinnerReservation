package com.order.bll;

import java.util.List;

import com.order.bean.Customers;
import com.order.dao.subsystem.CustomersDAO;

public class SignInBiz {
	public static Customers staticCustomer= null;
	public int check(String username, String password) {
		CustomersDAO customerDao = new CustomersDAO();
		List list = customerDao.checkCustomer(username, password);
		if(list.size()==0){
			return -1;
		}else{
			staticCustomer = (Customers) list.get(0);
			return staticCustomer.getCustomerId();
		}
	}

}
