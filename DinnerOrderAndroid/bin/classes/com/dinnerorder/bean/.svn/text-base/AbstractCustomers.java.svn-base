package com.order.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCustomers entity provides the base persistence definition of the
 * Customers entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCustomers implements java.io.Serializable {

	// Fields

	private Integer customerId;
	private String userName;
	private String password;
	private Date registerDate;
	private String email;
	private String address;
	private Integer totalCost;
	private String customerPhone;
	private Set orderses = new HashSet(0);
	private Set bonuspointses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCustomers() {
	}

	/** minimal constructor */
	public AbstractCustomers(Integer customerId) {
		this.customerId = customerId;
	}

	/** full constructor */
	public AbstractCustomers(Integer customerId, String userName,
			String password, Date registerDate, String email, String address,
			Integer totalCost, String customerPhone, Set orderses,
			Set bonuspointses) {
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.registerDate = registerDate;
		this.email = email;
		this.address = address;
		this.totalCost = totalCost;
		this.customerPhone = customerPhone;
		this.orderses = orderses;
		this.bonuspointses = bonuspointses;
	}

	// Property accessors

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getBonuspointses() {
		return this.bonuspointses;
	}

	public void setBonuspointses(Set bonuspointses) {
		this.bonuspointses = bonuspointses;
	}

}