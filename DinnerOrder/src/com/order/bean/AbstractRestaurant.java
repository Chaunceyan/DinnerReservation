package com.order.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractRestaurant entity provides the base persistence definition of the
 * Restaurant entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRestaurant implements java.io.Serializable {

	// Fields

	private Integer restaurantId;
	private String resName;
	private String resAddress;
	private String resPhone;
	private String resDescription;
	private String resType;
	private Set bonuspointses = new HashSet(0);
	private Set productses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractRestaurant() {
	}

	/** minimal constructor */
	public AbstractRestaurant(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	/** full constructor */
	public AbstractRestaurant(Integer restaurantId, String resName,
			String resAddress, String resPhone, String resDescription,
			String resType, Set bonuspointses, Set productses) {
		this.restaurantId = restaurantId;
		this.resName = resName;
		this.resAddress = resAddress;
		this.resPhone = resPhone;
		this.resDescription = resDescription;
		this.resType = resType;
		this.bonuspointses = bonuspointses;
		this.productses = productses;
	}

	// Property accessors

	public Integer getRestaurantId() {
		return this.restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResAddress() {
		return this.resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getResPhone() {
		return this.resPhone;
	}

	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}

	public String getResDescription() {
		return this.resDescription;
	}

	public void setResDescription(String resDescription) {
		this.resDescription = resDescription;
	}

	public String getResType() {
		return this.resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public Set getBonuspointses() {
		return this.bonuspointses;
	}

	public void setBonuspointses(Set bonuspointses) {
		this.bonuspointses = bonuspointses;
	}

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

}