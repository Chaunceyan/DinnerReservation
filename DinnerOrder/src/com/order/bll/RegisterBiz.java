package com.order.bll;

import com.order.bean.Customers;
import com.order.dao.subsystem.CustomersDAO;

public class RegisterBiz {

	public void addCustomer(Customers customer) {
		CustomersDAO cd = new CustomersDAO();
		cd.getSession().beginTransaction();
		cd.save(customer);
		cd.getSession().getTransaction().commit();
	}

}
