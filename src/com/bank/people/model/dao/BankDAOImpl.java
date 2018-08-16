package com.bank.people.model.dao;

import java.util.ArrayList;

import com.bank.people.framework.bean.BankAccount;
import com.bank.people.framework.bean.Customer;
import com.bank.people.framework.dao.BankDAO;
import com.bank.people.model.bean.PeopleCurrentAccount;
import com.bank.people.model.bean.PeopleSavingAccount;


public class BankDAOImpl implements BankDAO {
	
	public BankDAOImpl() {
		
		Customer c1= new Customer("ad",565463459,"asdd@sfdc.in","29/10/1996");
		BankAccount acc1= new PeopleSavingAccount(c1,29000,true);
		
		Customer c2= new Customer("afgd",563459,"asdd@sfdhnc.in","29/11/1995");
		BankAccount acc2= new PeopleSavingAccount(c2,35000,false);
		
		Customer c3= new Customer("asadd",545634159,"asadad@sffddc.in","28/12/1996");
		BankAccount acc3= new PeopleCurrentAccount(c3,694,500);
		
		Customer c4= new Customer("ad",5601154,"asdad@sflodc.in","23/10/2996");
		BankAccount acc4= new PeopleCurrentAccount(c4,5410,900);
		
		addAccount(acc1);
		addAccount(acc2);
		addAccount(acc3);
		addAccount(acc4);
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(acc3);
		System.out.println(acc4);
	}

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
