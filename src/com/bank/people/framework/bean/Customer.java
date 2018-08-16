package com.bank.people.framework.bean;

public class Customer {
	
	private final int customerId;
	private String customerName;
	private long contactNumber;
	private String emailId;
	private String dateOfBirth;
	
	private static int custId;
	
	static {
		custId = 200;
	}
	
	{
		this.customerId = ++custId;
	}

	public Customer(String customerName, long contactNumber, String emailId, String dateOfBirth) {
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
