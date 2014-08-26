package com.dinnerorder.utils;

import android.app.Application;

import com.dinnerorder.bean.Cart;

public class DinnerOrderApplication extends Application{
	private Cart cart;
	private int id;

	private String userName;
	private String password;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
