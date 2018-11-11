package com.xeno.shoporganizer.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Email {
	private int emailID;
	private String emailAddress;
	private String pword;
	private LocalDate registeredDate;
	private boolean active = true;
	
	public Email() {
		super();
	}
	
	public Email(String emailAddress, String pword) {
		super();
		this.emailAddress = emailAddress;
		this.pword = pword;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public LocalDate getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}
	public int getEmailID() {
		return emailID;
	}

	public void setEmailID(int emailID) {
		this.emailID = emailID;
	}

	@Override
	public String toString() {
		return "Email [emailID=" + emailID + ", emailAddress=" + emailAddress + ", pword=" + pword + ", registeredDate="
				+ registeredDate + "]";
	}
	
}
