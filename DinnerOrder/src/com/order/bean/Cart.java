package com.order.bean;

import java.util.LinkedHashMap;
import java.util.Map;

//购物车
public class Cart {
	private static Cart cart = new Cart();
	//key:购物项中的书的id。value：购物项
	private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
	private int num;//总数量
	private float price;//总计
	public void clear(){
		cart.getItems().clear();
		cart.setNum(0);
		cart.setPrice(0);
	}
	public static Cart getInstance(){
		return cart;
	}
	private Cart(){
		
	}
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	
	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNum() {
		num=0;
		for(Map.Entry<Integer, CartItem> me:items.entrySet()){
			num+=me.getValue().getNum();
		}
		return num;
	}

	public float getPrice() {
		price = 0;
		for(Map.Entry<Integer, CartItem> me:items.entrySet()){
			price+=me.getValue().getPrice();
		}
		return price;
	}

	/**
	 * 把购买的书籍放入购物车中的items中
	 */
	public void addProducts2Cart(Products product){
		//判断买的书之前有没有买过
		if(items.containsKey(product.getProductsId())){
		//买过：只是数量加1
			CartItem item = items.get(product.getProductsId());
			item.setNum(item.getNum()+1);
		}else{
		//没有买过：创建一个新的购物项，加入到items中
			CartItem item = new CartItem(product);
			item.setNum(1);
			items.put(product.getProductsId(), item);
		}
	}
}
