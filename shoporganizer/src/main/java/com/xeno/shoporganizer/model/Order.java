package com.xeno.shoporganizer.model;

import java.sql.Date;

public class Order {
	
	//pk
	private int orderID;
	private Date orderDate;
	// all items on the order received
	private Date orderCompleteDate;
	private int shopID;
	private int paymentID;
	// True if has one or more items being returned
	private boolean hasReturnItem;
    // True if refund received for all outstanding returning items
	private boolean returnCompleted;
	private String notes;
	//purchase order number
	private String orderNumber;
	
	public Order() {
		super();
	}
	
	public Order(Date orderDate, int shopID, String orderNumber) {
		super();
		this.orderDate = orderDate;
		this.shopID = shopID;
		this.orderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderCompleteDate() {
		return orderCompleteDate;
	}
	public void setOrderCompleteDate(Date orderCompleteDate) {
		this.orderCompleteDate = orderCompleteDate;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public boolean isHasReturnItem() {
		return hasReturnItem;
	}
	public void setHasReturnItem(boolean hasReturnItem) {
		this.hasReturnItem = hasReturnItem;
	}
	public boolean isReturnCompleted() {
		return returnCompleted;
	}
	public void setReturnCompleted(boolean returnCompleted) {
		this.returnCompleted = returnCompleted;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getShopID() {
		return shopID;
	}

	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
}
