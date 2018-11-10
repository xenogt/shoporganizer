package com.xeno.shoporganizer.model;

import java.sql.Date;

public class ShopAccount {
	
	private int shopID;
	private String shopName;
	private String registeredID;
	private String shopURL;
	private Date registeredDate;
	private int emailID;
	private String phone;
	private String address;
	private int paymentID;
	private String notes;
	private String password;
	
	public ShopAccount() {
		super();
	}
	
	public ShopAccount(String shopName, String registeredID) {
		super();
		this.shopName = shopName;
		this.registeredID = registeredID;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getRegisteredID() {
		return registeredID;
	}
	public void setRegisteredID(String registeredID) {
		this.registeredID = registeredID;
	}
	public String getShopURL() {
		return shopURL;
	}
	public void setShopURL(String shopURL) {
		this.shopURL = shopURL;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public int getEmailID() {
		return emailID;
	}
	public void setEmailID(int emailID) {
		this.emailID = emailID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getShopID() {
		return shopID;
	}

	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
	
}
