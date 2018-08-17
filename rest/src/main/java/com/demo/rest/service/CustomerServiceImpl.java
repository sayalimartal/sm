package com.demo.rest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.rest.dao.CustomerDAOImpl;
import com.demo.rest.pojo.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAOImpl dao;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public ArrayList<Customer> viewAllCustomers() {
		return dao.viewAllCustomers();
	}

}
