package com.dinnerorder.bean;

import java.io.Serializable;

//¹ºÎïÏî
public class CartItem implements Serializable{

	private Products products;
	private int num;

	public CartItem(Products products) {
		super();
		this.products = products;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return products.getProductsPrice()*products.getProductsDiscount()/100*num;
	}
}
