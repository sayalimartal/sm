package com.moneymoney.app.model.service;

import java.util.ArrayList;
import java.util.Set;

import com.moneymoney.app.model.dao.DAOImpl;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;
import com.moneymoney.framework.account.pojo.PaymentGateway;
import com.moneymoney.framework.service.Service;

public class ServiceImpl implements Service {
	DAOImpl dao = new DAOImpl();
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#addBankAccount(com.moneymoney.framework.account.pojo.BankAccount)
	 */
	@Override
	public void addBankAccount(BankAccount bankAccount) {
		System.out.println(bankAccount);
		dao.addBankAccount(bankAccount);
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#viewAll()
	 */
	@Override
	public ArrayList<BankAccount> viewAllAccounts(){
		return dao.viewAllAccounts();
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#FundTransfer(com.moneymoney.framework.account.pojo.BankAccount, com.moneymoney.framework.account.pojo.BankAccount, double)
	 */
	@Override
	public boolean FundTransfer(BankAccount sender,BankAccount reciever,double amount) {
		return PaymentGateway.transfer(sender, reciever, amount);
	}

	@Override
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}
	
	@Override
	public ArrayList<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return dao.viewAllCustomers();
	}

	@Override
	public BankAccount searchAccountById(int num) {
		return dao.searchAccountById(num);
	}
	
	public String withdraw(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		return account.withdraw(amount);		
	}
	public void deposit(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		account.deposit(amount);		
	}
}
