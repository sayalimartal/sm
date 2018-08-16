package com.bank.people.model.service;

import java.util.ArrayList;

import com.bank.people.framework.bean.BankAccount;
import com.bank.people.framework.bean.Customer;
import com.bank.people.framework.bean.PaymentGateway;
import com.bank.people.framework.service.BankService;
import com.bank.people.model.dao.BankDAOImpl;


public class BankServiceImpl implements BankService{
	
	BankDAOImpl dao = new BankDAOImpl();

	@Override
	public void addAccount(BankAccount bankAccount) {
		dao.addAccount(bankAccount);	
	}

	@Override
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);		
	}

	@Override
	public ArrayList<BankAccount> viewAllAccounts() {
		return dao.viewAllAccounts();
	}

	@Override
	public ArrayList<Customer> viewAllCustomers() {
		return dao.viewAllCustomers();
	}

	@Override
	public BankAccount getAccountById(int accountId) {
		return dao.getAccountById(accountId);
	}

	@Override
	public boolean fundTransfer(BankAccount sender, BankAccount receiver, double amount) {
		return PaymentGateway.transfer(sender, receiver, amount);
	}

	public String withdraw(int accountNumber,double amount) {
		BankAccount account = getAccountById(accountNumber);
		return account.withdraw(amount);		
	}
	
	public void deposit(int accountNumber,double amount) {
		BankAccount account = getAccountById(accountNumber);
		account.deposit(amount);		
	}
}
