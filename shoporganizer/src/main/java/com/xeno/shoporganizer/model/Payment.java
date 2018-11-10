package com.xeno.shoporganizer.model;

import java.sql.Date;

public class Payment {
	
	private int paymentID;
	private int paymentMethodID;
	private Date payOnDate;
	private String confirmation;
	private String notes;
	
	public Payment() {
		super();
	}
	
	public Payment(int orderID, int paymentMethodID, Date payOnDate, String confirmation, String notes) {
		super();
		this.paymentMethodID = paymentMethodID;
		this.payOnDate = payOnDate;
		this.confirmation = confirmation;
		this.notes = notes;
	}
	
	public int getPaymentMethodID() {
		return paymentMethodID;
	}
	public void setPaymentMethodID(int paymentMethodID) {
		this.paymentMethodID = paymentMethodID;
	}
	public String getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public Date getPayOnDate() {
		return payOnDate;
	}

	public void setPayOnDate(Date payOnDate) {
		this.payOnDate = payOnDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
