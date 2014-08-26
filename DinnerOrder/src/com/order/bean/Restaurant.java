package com.order.bean;

import java.util.Set;

/**
 * Restaurant entity. @author MyEclipse Persistence Tools
 */
public class Restaurant extends AbstractRestaurant implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Restaurant() {
	}

	/** minimal constructor */
	public Restaurant(Integer restaurantId) {
		super(restaurantId);
	}

	/** full constructor */
	public Restaurant(Integer restaurantId, String resName, String resAddress,
			String resPhone, String resDescription, String resType,
			Set bonuspointses, Set productses) {
		super(restaurantId, resName, resAddress, resPhone, resDescription,
				resType, bonuspointses, productses);
	}

}
