package com.dinnerorder.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Productcategories entity provides the base persistence definition of
 * the Productcategories entity. @author MyEclipse Persistence Tools
 */

public  class Productcategories implements java.io.Serializable {

	// Fields

	private Integer productCategoriedId;
	private String categoryName;
	private String categoryPicture;
	public Integer getProductCategoriedId() {
		return productCategoriedId;
	}
	public void setProductCategoriedId(Integer productCategoriedId) {
		this.productCategoriedId = productCategoriedId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryPicture() {
		return categoryPicture;
	}
	public void setCategoryPicture(String categoryPicture) {
		this.categoryPicture = categoryPicture;
	}

}