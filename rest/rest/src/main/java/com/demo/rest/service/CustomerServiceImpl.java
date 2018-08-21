package com.demo.rest.service;

import java.util.Collection;

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
	public Collection<Customer> viewAllCustomers() {
		return dao.viewAllCustomers();
	}

	

	@Override
	public Customer updateCustomer(Customer customer) {
		return dao.updateCustomer(customer);
	}

	@Override
	public String deleteCustomer(Customer customer) {
		return dao.deleteCustomer(customer);
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return dao.viewCustomer(customerId);
	}

}
