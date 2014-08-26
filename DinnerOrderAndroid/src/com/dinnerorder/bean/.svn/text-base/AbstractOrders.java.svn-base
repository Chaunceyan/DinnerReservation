package com.order.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractOrders entity provides the base persistence definition of the Orders
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Customers customers;
	private Date orderTime;
	private float totalMoney;
	private Date deliverTime;
	private String consigneeName;
	private String consigneeAddress;
	private String status;
	private String payMethod;
	private Set orderdetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractOrders() {
	}

	/** minimal constructor */
	public AbstractOrders(Integer orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public AbstractOrders(Integer orderId, Customers customers, Date orderTime,
			float totalMoney, Date deliverTime, String consigneeName,
			String consigneeAddress, String status, String payMethod,
			Set orderdetailses) {
		this.orderId = orderId;
		this.customers = customers;
		this.orderTime = orderTime;
		this.totalMoney = totalMoney;
		this.deliverTime = deliverTime;
		this.consigneeName = consigneeName;
		this.consigneeAddress = consigneeAddress;
		this.status = status;
		this.payMethod = payMethod;
		this.orderdetailses = orderdetailses;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public float getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Date getDeliverTime() {
		return this.deliverTime;
	}

	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}

	public String getConsigneeName() {
		return this.consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return this.consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Set getOrderdetailses() {
		return this.orderdetailses;
	}

	public void setOrderdetailses(Set orderdetailses) {
		this.orderdetailses = orderdetailses;
	}

}