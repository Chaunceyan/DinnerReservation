package com.dinnerorder.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Restaurant entity provides the base persistence definition of the
 * Restaurant entity. @author MyEclipse Persistence Tools
 */

public  class Restaurant implements java.io.Serializable {

	// Fields

	private Integer restaurantId;
	private String resName;
	private String resAddress;
	private String resPhone;
	private String resDescription;
	private String resType;
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	public String getResPhone() {
		return resPhone;
	}
	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}
	public String getResDescription() {
		return resDescription;
	}
	public void setResDescription(String resDescription) {
		this.resDescription = resDescription;
	}
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}

}