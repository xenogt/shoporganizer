package com.xeno.shoporganizer.model;

public class PaymentMethod {
	
	private int paymentMethodID;
	private String financialInstitude;
	private String acctNum;
	private String notes;
	
	public PaymentMethod() {
		super();
	}
	
	public PaymentMethod(String financialInstitude, String acctNum) {
		super();
		this.financialInstitude = financialInstitude;
		this.acctNum = acctNum;
	}
	
	public String getFinancialInstitude() {
		return financialInstitude;
	}
	public void setFinancialInstitude(String financialInstitude) {
		this.financialInstitude = financialInstitude;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getPaymentMethodID() {
		return paymentMethodID;
	}

	public void setPaymentMethodID(int paymentMethodID) {
		this.paymentMethodID = paymentMethodID;
	}
}
