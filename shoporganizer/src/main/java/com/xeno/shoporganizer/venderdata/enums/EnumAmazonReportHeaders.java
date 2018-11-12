package com.xeno.shoporganizer.venderdata.enums;

public enum EnumAmazonReportHeaders {
	
	orderDate("Order Date"),
	orderID("Order ID"),
	paymentInstrumentType("Payment Instrument Type"),
	website("Website"),
	purchaseOrderNumber("Purchase Order Number"),
	orderingCustomerEmail("Ordering Customer Email"),
	shipmentDate("Shipment Date"),
	shippingAddressName("Shipping Address Name"),
	shippingAddressStreet1("Shipping Address Street 1"),
	shippingAddressStreet2("Shipping Address Street 2"),
	shippingAddressCity("Shipping Address City"),
	shippingAddressState("Shipping Address State"),
	shippingAddressZip("Shipping Address Zip"),
	orderStatus("Order Status"),
	carrierNameAndTrackingNumber("Carrier Name & Tracking Number"),
	subtotal("Subtotal"),
	shippingCharge("Shipping Charge"),
	taxBeforePromotions("Tax Before Promotions"),
	totalPromotions("Total Promotions"),
	taxCharged("Tax Charged"),
	totalCharged("Total Charged"),
	buyerName("Buyer Name"),
	groupName("Group Name");
	
	private String headerText;
	
	EnumAmazonReportHeaders(String headerText) {
		this.headerText = headerText;
	}
	
	public String getHeaderText() {
		return this.headerText;
	}
}
