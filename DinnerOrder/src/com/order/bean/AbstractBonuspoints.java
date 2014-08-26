package com.order.bean;

/**
 * AbstractBonuspoints entity provides the base persistence definition of the
 * Bonuspoints entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBonuspoints implements java.io.Serializable {

	// Fields

	private Integer bonusPointsId;
	private Restaurant restaurant;
	private Customers customers;
	private Integer pointsCount;

	// Constructors

	/** default constructor */
	public AbstractBonuspoints() {
	}

	/** minimal constructor */
	public AbstractBonuspoints(Integer bonusPointsId) {
		this.bonusPointsId = bonusPointsId;
	}

	/** full constructor */
	public AbstractBonuspoints(Integer bonusPointsId, Restaurant restaurant,
			Customers customers, Integer pointsCount) {
		this.bonusPointsId = bonusPointsId;
		this.restaurant = restaurant;
		this.customers = customers;
		this.pointsCount = pointsCount;
	}

	// Property accessors

	public Integer getBonusPointsId() {
		return this.bonusPointsId;
	}

	public void setBonusPointsId(Integer bonusPointsId) {
		this.bonusPointsId = bonusPointsId;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Integer getPointsCount() {
		return this.pointsCount;
	}

	public void setPointsCount(Integer pointsCount) {
		this.pointsCount = pointsCount;
	}

}