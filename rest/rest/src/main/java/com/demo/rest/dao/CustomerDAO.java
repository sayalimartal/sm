package com.demo.rest.dao;

import java.util.Collection;

import com.demo.rest.pojo.Customer;

public interface CustomerDAO {
	Customer addCustomer(Customer customer);
	Collection<Customer> viewAllCustomers();
	String deleteCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer viewCustomer(int customerId);
}
