package com.order.bean;

import java.util.Date;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
public class Orders extends AbstractOrders implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Integer orderId) {
		super(orderId);
	}

	/** full constructor */
	public Orders(Integer orderId, Customers customers, Date orderTime,
			float totalMoney, Date deliverTime, String consigneeName,
			String consigneeAddress, String status, String payMethod,
			Set orderdetailses) {
		super(orderId, customers, orderTime, totalMoney, deliverTime,
				consigneeName, consigneeAddress, status, payMethod,
				orderdetailses);
	}

}
