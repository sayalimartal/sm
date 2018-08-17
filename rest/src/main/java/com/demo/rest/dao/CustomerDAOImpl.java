package com.demo.rest.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.demo.rest.pojo.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {
	
	public CustomerDAOImpl() {
		
		Customer c1= new Customer("ad",565463459,"asdd@sfdc.in","29/10/1996");
		Customer c2= new Customer("afgd",563459,"asdd@sfdhnc.in","29/11/1995");
		Customer c3= new Customer("asadd",545634159,"asadad@sffddc.in","28/12/1996");
		Customer c4= new Customer("ad",5601154,"asdad@sflodc.in","23/10/2996");
		
		addCustomer(c1);
		addCustomer(c2);
		addCustomer(c3);
		addCustomer(c4);

	}
	
	

	private static ArrayList<Customer> customerList;
	
	static {
		customerList = new ArrayList<>();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerList.add(customer);
		return customer;
	}

	@Override
	public ArrayList<Customer> viewAllCustomers() {
		return customerList;
	}

}
