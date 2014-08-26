package com.order.bean;

/**
 * AbstractOrderdetails entity provides the base persistence definition of the
 * Orderdetails entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrderdetails implements java.io.Serializable {

	// Fields

	private Integer orderDetailId;
	private Products products;
	private Orders orders;
	private float price;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public AbstractOrderdetails() {
	}

	/** minimal constructor */
	public AbstractOrderdetails(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	/** full constructor */
	public AbstractOrderdetails(Integer orderDetailId, Products products,
			Orders orders, float price, Integer quantity) {
		this.orderDetailId = orderDetailId;
		this.products = products;
		this.orders = orders;
		this.price = price;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}