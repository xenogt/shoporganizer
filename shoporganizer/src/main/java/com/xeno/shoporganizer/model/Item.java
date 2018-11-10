package com.xeno.shoporganizer.model;

import java.sql.Date;

public class Item {
	
	private int itemID;
	private Date dateReceived;
	private String itemName;
	private double cost;
	private String description;
	private String itemUrl;
	private int orderID;
	private Date returnRequestedDate;
	private Date returnShippedDate;
	private boolean refundReceived;
	private String notes;
	
	public Item() {
		super();
	}
	public Item(String itemName, double cost, String description, int orderID) {
		super();
		this.itemName = itemName;
		this.cost = cost;
		this.description = description;
		this.orderID = orderID;
	}
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getItemUrl() {
		return itemUrl;
	}
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getReturnRequestedDate() {
		return returnRequestedDate;
	}
	public void setReturnRequestedDate(Date returnRequestedDate) {
		this.returnRequestedDate = returnRequestedDate;
	}
	public Date getReturnShippedDate() {
		return returnShippedDate;
	}
	public void setReturnShippedDate(Date returnShippedDate) {
		this.returnShippedDate = returnShippedDate;
	}
	public boolean isRefundReceived() {
		return refundReceived;
	}
	public void setRefundReceived(boolean refundReceived) {
		this.refundReceived = refundReceived;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + orderID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (orderID != other.orderID)
			return false;
		return true;
	}
}
