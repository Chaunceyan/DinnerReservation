package com.order.bean;

import java.util.LinkedHashMap;
import java.util.Map;

//���ﳵ
public class Cart {
	private static Cart cart = new Cart();
	//key:�������е����id��value��������
	private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
	private int num;//������
	private float price;//�ܼ�
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
	 * �ѹ�����鼮���빺�ﳵ�е�items��
	 */
	public void addProducts2Cart(Products product){
		//�ж������֮ǰ��û�����
		if(items.containsKey(product.getProductsId())){
		//�����ֻ��������1
			CartItem item = items.get(product.getProductsId());
			item.setNum(item.getNum()+1);
		}else{
		//û�����������һ���µĹ�������뵽items��
			CartItem item = new CartItem(product);
			item.setNum(1);
			items.put(product.getProductsId(), item);
		}
	}
}
