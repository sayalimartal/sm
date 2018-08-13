package com.bank.people.framework.dao;

import java.util.ArrayList;

import com.bank.people.framework.bean.BankAccount;
import com.bank.people.framework.bean.Customer;

public interface BankDAO {
	
	void addAccount(BankAccount bankAccount);
	void addCustomer(Customer customer);
	
	ArrayList<BankAccount> viewAllAccounts();
	ArrayList<Customer> viewAllCustomers();
	BankAccount getAccountById(int accountId);

}