package com.demo.rest.dao;

import java.util.ArrayList;

import com.demo.rest.pojo.Customer;

public interface CustomerDAO {
	Customer addCustomer(Customer customer);
	ArrayList<Customer> viewAllCustomers();
	String deleteCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
}
