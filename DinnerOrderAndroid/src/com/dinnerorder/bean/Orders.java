package com.dinnerorder.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity provides the base persistence definition of the Orders
 * entity. @author MyEclipse Persistence Tools
 */

public  class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private int customersID;
	private String orderTime;
	private float totalMoney;
	private String deliverTime;
	private String consigneeName;
	private String consigneeAddress;
	private String status;
	private String payMethod;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public int getCustomersID() {
		return customersID;
	}
	public void setCustomersID(int customersID) {
		this.customersID = customersID;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	
}