package com.demo.rest.service;

import java.util.ArrayList;

import com.demo.rest.pojo.Customer;


public interface CustomerService {
	Customer addCustomer(Customer customer);
	ArrayList<Customer> viewAllCustomers();
}
