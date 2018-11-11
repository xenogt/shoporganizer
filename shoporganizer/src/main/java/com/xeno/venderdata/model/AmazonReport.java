package com.xeno.venderdata.model;

import java.sql.Date;

public class AmazonReport {
	
	private int reportID;
	
	private Date orderDate;
	private String orderID;
	private String paymentInstrumentType;
	private String website;
	private String purchaseOrderNumber;
	private String orderingCustomerEmail;
	private Date shipmentDate;
	private String shippingAddressName;
	private String shippingAddressStreet1;
	private String shippingAddressStreet2;
	private String shippingAddressCity;
	private String shippingAddressState;
	private String shippingAddressZip;
	private String orderStatus;
	private String carrierNameAndTrackingNumber;
	private double subtotal;
	private double shippingCharge;
	private double taxBeforePromotions;
	private double totalPromotions;
	private double taxCharged;
	private double totalCharged;
	private String buyerName;
	private String groupName;
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getPaymentInstrumentType() {
		return paymentInstrumentType;
	}
	public void setPaymentInstrumentType(String paymentInstrumentType) {
		this.paymentInstrumentType = paymentInstrumentType;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getOrderingCustomerEmail() {
		return orderingCustomerEmail;
	}
	public void setOrderingCustomerEmail(String orderingCustomerEmail) {
		this.orderingCustomerEmail = orderingCustomerEmail;
	}
	public Date getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public String getShippingAddressName() {
		return shippingAddressName;
	}
	public void setShippingAddressName(String shippingAddressName) {
		this.shippingAddressName = shippingAddressName;
	}
	public String getShippingAddressStreet1() {
		return shippingAddressStreet1;
	}
	public void setShippingAddressStreet1(String shippingAddressStreet1) {
		this.shippingAddressStreet1 = shippingAddressStreet1;
	}
	public String getShippingAddressStreet2() {
		return shippingAddressStreet2;
	}
	public void setShippingAddressStreet2(String shippingAddressStreet2) {
		this.shippingAddressStreet2 = shippingAddressStreet2;
	}
	public String getShippingAddressCity() {
		return shippingAddressCity;
	}
	public void setShippingAddressCity(String shippingAddressCity) {
		this.shippingAddressCity = shippingAddressCity;
	}
	public String getShippingAddressState() {
		return shippingAddressState;
	}
	public void setShippingAddressState(String shippingAddressState) {
		this.shippingAddressState = shippingAddressState;
	}
	public String getShippingAddressZip() {
		return shippingAddressZip;
	}
	public void setShippingAddressZip(String shippingAddressZip) {
		this.shippingAddressZip = shippingAddressZip;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCarrierNameAndTrackingNumber() {
		return carrierNameAndTrackingNumber;
	}
	public void setCarrierNameAndTrackingNumber(String carrierNameAndTrackingNumber) {
		this.carrierNameAndTrackingNumber = carrierNameAndTrackingNumber;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getShippingCharge() {
		return shippingCharge;
	}
	public void setShippingCharge(double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}
	public double getTaxBeforePromotions() {
		return taxBeforePromotions;
	}
	public void setTaxBeforePromotions(double taxBeforePromotions) {
		this.taxBeforePromotions = taxBeforePromotions;
	}
	public double getTotalPromotions() {
		return totalPromotions;
	}
	public void setTotalPromotions(double totalPromotions) {
		this.totalPromotions = totalPromotions;
	}
	public double getTaxCharged() {
		return taxCharged;
	}
	public void setTaxCharged(double taxCharged) {
		this.taxCharged = taxCharged;
	}
	public double getTotalCharged() {
		return totalCharged;
	}
	public void setTotalCharged(double totalCharged) {
		this.totalCharged = totalCharged;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

}
