package com.dinnerorder.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Products entity provides the base persistence definition of the
 * Products entity. @author MyEclipse Persistence Tools
 */

public class Products implements java.io.Serializable {

	// Fields

	private Integer productsId;
	private int restaurantID;
	private int productcategoriesID;
	private String productsName;
	private float productsPrice;
	private String productsDescription;
	private Integer productsDiscount;
	private String discountStartTime;
	private String discountEndTime;
	private String productPicture;
	
	public Integer getProductsId() {
		return productsId;
	}
	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public int getProductcategoriesID() {
		return productcategoriesID;
	}
	public void setProductcategoriesID(int productcategoriesID) {
		this.productcategoriesID = productcategoriesID;
	}
	public String getProductsName() {
		return productsName;
	}
	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}
	public float getProductsPrice() {
		return productsPrice;
	}
	public void setProductsPrice(float productsPrice) {
		this.productsPrice = productsPrice;
	}
	public String getProductsDescription() {
		return productsDescription;
	}
	public void setProductsDescription(String productsDescription) {
		this.productsDescription = productsDescription;
	}
	public Integer getProductsDiscount() {
		return productsDiscount;
	}
	public void setProductsDiscount(Integer productsDiscount) {
		this.productsDiscount = productsDiscount;
	}
	public String getDiscountStartTime() {
		return discountStartTime;
	}
	public void setDiscountStartTime(String discountStartTime) {
		this.discountStartTime = discountStartTime;
	}
	public String getDiscountEndTime() {
		return discountEndTime;
	}
	public void setDiscountEndTime(String discountEndTime) {
		this.discountEndTime = discountEndTime;
	}
	public String getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}


}