package com.xeno.shoporganizer.model;

import java.time.LocalDate;

public class Order {
	
	//pk
	private int orderID;
	private LocalDate orderDate;
	// all items on the order received
	private LocalDate orderCompleteDate;
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
	
	public Order(LocalDate orderDate, int shopID, String orderNumber) {
		super();
		this.orderDate = orderDate;
		this.shopID = shopID;
		this.orderNumber = orderNumber;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getOrderCompleteDate() {
		return orderCompleteDate;
	}
	public void setOrderCompleteDate(LocalDate orderCompleteDate) {
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
