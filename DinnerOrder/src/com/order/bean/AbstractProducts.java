package com.order.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractProducts entity provides the base persistence definition of the
 * Products entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProducts implements java.io.Serializable {

	// Fields

	private Integer productsId;
	private Restaurant restaurant;
	private Productcategories productcategories;
	private String productsName;
	private float productsPrice;
	private String productsDescription;
	private Integer productsDiscount;
	private Date discountStartTime;
	private Date discountEndTime;
	private String productPicture;
	private Set orderdetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractProducts() {
	}

	/** minimal constructor */
	public AbstractProducts(Integer productsId) {
		this.productsId = productsId;
	}

	/** full constructor */
	public AbstractProducts(Integer productsId, Restaurant restaurant,
			Productcategories productcategories, String productsName,
			float productsPrice, String productsDescription,
			Integer productsDiscount, Date discountStartTime,
			Date discountEndTime, String productPicture, Set orderdetailses) {
		this.productsId = productsId;
		this.restaurant = restaurant;
		this.productcategories = productcategories;
		this.productsName = productsName;
		this.productsPrice = productsPrice;
		this.productsDescription = productsDescription;
		this.productsDiscount = productsDiscount;
		this.discountStartTime = discountStartTime;
		this.discountEndTime = discountEndTime;
		this.productPicture = productPicture;
		this.orderdetailses = orderdetailses;
	}

	// Property accessors

	public Integer getProductsId() {
		return this.productsId;
	}

	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Productcategories getProductcategories() {
		return this.productcategories;
	}

	public void setProductcategories(Productcategories productcategories) {
		this.productcategories = productcategories;
	}

	public String getProductsName() {
		return this.productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public float getProductsPrice() {
		return this.productsPrice;
	}

	public void setProductsPrice(float productsPrice) {
		this.productsPrice = productsPrice;
	}

	public String getProductsDescription() {
		return this.productsDescription;
	}

	public void setProductsDescription(String productsDescription) {
		this.productsDescription = productsDescription;
	}

	public Integer getProductsDiscount() {
		return this.productsDiscount;
	}

	public void setProductsDiscount(Integer productsDiscount) {
		this.productsDiscount = productsDiscount;
	}

	public Date getDiscountStartTime() {
		return this.discountStartTime;
	}

	public void setDiscountStartTime(Date discountStartTime) {
		this.discountStartTime = discountStartTime;
	}

	public Date getDiscountEndTime() {
		return this.discountEndTime;
	}

	public void setDiscountEndTime(Date discountEndTime) {
		this.discountEndTime = discountEndTime;
	}

	public String getProductPicture() {
		return this.productPicture;
	}

	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}

	public Set getOrderdetailses() {
		return this.orderdetailses;
	}

	public void setOrderdetailses(Set orderdetailses) {
		this.orderdetailses = orderdetailses;
	}

}