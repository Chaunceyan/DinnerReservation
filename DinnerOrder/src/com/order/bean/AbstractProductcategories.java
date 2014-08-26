package com.order.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractProductcategories entity provides the base persistence definition of
 * the Productcategories entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProductcategories implements java.io.Serializable {

	// Fields

	private Integer productCategoriedId;
	private String categoryName;
	private String categoryPicture;
	private Set productses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractProductcategories() {
	}

	/** minimal constructor */
	public AbstractProductcategories(Integer productCategoriedId) {
		this.productCategoriedId = productCategoriedId;
	}

	/** full constructor */
	public AbstractProductcategories(Integer productCategoriedId,
			String categoryName, String categoryPicture, Set productses) {
		this.productCategoriedId = productCategoriedId;
		this.categoryName = categoryName;
		this.categoryPicture = categoryPicture;
		this.productses = productses;
	}

	// Property accessors

	public Integer getProductCategoriedId() {
		return this.productCategoriedId;
	}

	public void setProductCategoriedId(Integer productCategoriedId) {
		this.productCategoriedId = productCategoriedId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryPicture() {
		return this.categoryPicture;
	}

	public void setCategoryPicture(String categoryPicture) {
		this.categoryPicture = categoryPicture;
	}

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

}