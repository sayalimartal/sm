package com.bank.people.model.bean;

import java.util.Arrays;

import com.bank.people.framework.bean.Customer;

public class PeopleCustomer extends Customer {
	
	private int[] accountNumbers = new int[100];
	int i=0;
	
	public PeopleCustomer(String customerName, long contactNumber, String emailId, String dateOfBirth) {
		super(customerName, contactNumber, emailId, dateOfBirth);
	}

	public int[] getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(int accountNumber) {
		this.accountNumbers[i] = accountNumber;
		i++;
	}

	@Override
	public String toString() {
		return "PeopleCustomer [accountNumbers=" + Arrays.toString(accountNumbers) + "]";
	}
	
}
