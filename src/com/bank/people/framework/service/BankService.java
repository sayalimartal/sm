package com.bank.people.framework.service;

import java.util.ArrayList;

import com.bank.people.framework.bean.BankAccount;
import com.bank.people.framework.bean.Customer;

public interface BankService {

	void addAccount(BankAccount bankAccount);
	void addCustomer(Customer customer);
	
	ArrayList<BankAccount> viewAllAccounts();
	ArrayList<Customer> viewAllCustomers();
	BankAccount getAccountById(int accountId);
	boolean fundTransfer(BankAccount sender, BankAccount receiver, double amount);
	
}