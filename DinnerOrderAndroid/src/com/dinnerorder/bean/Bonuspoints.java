package com.dinnerorder.bean;

/**
 * Bonuspoints entity provides the base persistence definition of the
 * Bonuspoints entity. @author MyEclipse Persistence Tools
 */

public class Bonuspoints implements java.io.Serializable {

	// Fields

	private Integer bonusPointsId;
	private int restaurantID;
	private int customersID;
	private Integer pointsCount;
	public Integer getBonusPointsId() {
		return bonusPointsId;
	}
	public void setBonusPointsId(Integer bonusPointsId) {
		this.bonusPointsId = bonusPointsId;
	}
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public int getCustomersID() {
		return customersID;
	}
	public void setCustomersID(int customersID) {
		this.customersID = customersID;
	}
	public Integer getPointsCount() {
		return pointsCount;
	}
	public void setPointsCount(Integer pointsCount) {
		this.pointsCount = pointsCount;
	}

	
}