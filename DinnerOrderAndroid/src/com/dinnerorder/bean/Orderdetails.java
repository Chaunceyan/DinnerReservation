package com.dinnerorder.bean;

/**
 * Orderdetails entity provides the base persistence definition of the
 * Orderdetails entity. @author MyEclipse Persistence Tools
 */

public  class Orderdetails implements java.io.Serializable {

	// Fields

	private Integer orderDetailID;
	private int productsID;
	private int ordersID;
	private float price;
	private Integer quantity;
	public Integer getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(Integer orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public int getProductsID() {
		return productsID;
	}
	public void setProductsID(int productsID) {
		this.productsID = productsID;
	}
	public int getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	

}