package com.bank.people.model.dao;

import java.util.ArrayList;

import com.bank.people.framework.bean.BankAccount;
import com.bank.people.framework.bean.Customer;
import com.bank.people.framework.dao.BankDAO;


public class BankDAOImpl implements BankDAO {
	
	private static ArrayList<BankAccount> bankAccounts;
	private static ArrayList<Customer> customerList;
	
	static {
		bankAccounts = new ArrayList<>();
		customerList = new ArrayList<>();
	}
	
	@Override
	public void addAccount(BankAccount bankAccount) {
		bankAccounts.add(bankAccount);	
	}
	
	@Override
	public void addCustomer(Customer customer) {	
		customerList.add(customer);
	}
	
	@Override
	public ArrayList<BankAccount> viewAllAccounts() {
		return bankAccounts;
	}
	
	@Override
	public ArrayList<Customer> viewAllCustomers() {
		return customerList;
	}
	
	@Override
	public BankAccount getAccountById(int accountId) {
		
		BankAccount account = null;
		for(BankAccount bankAccount : bankAccounts ) {
			if(bankAccount.getAccountNumber() == accountId) {
				account = bankAccount;
			}
		}
		return account;	
		}

}
