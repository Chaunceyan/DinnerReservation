package com.order.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPaymethod entity provides the base persistence definition of the
 * Paymethod entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPaymethod implements java.io.Serializable {

	// Fields

	private Integer payMethodId;
	private String methiodName;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPaymethod() {
	}

	/** minimal constructor */
	public AbstractPaymethod(Integer payMethodId) {
		this.payMethodId = payMethodId;
	}

	/** full constructor */
	public AbstractPaymethod(Integer payMethodId, String methiodName,
			Set orderses) {
		this.payMethodId = payMethodId;
		this.methiodName = methiodName;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getPayMethodId() {
		return this.payMethodId;
	}

	public void setPayMethodId(Integer payMethodId) {
		this.payMethodId = payMethodId;
	}

	public String getMethiodName() {
		return this.methiodName;
	}

	public void setMethiodName(String methiodName) {
		this.methiodName = methiodName;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}