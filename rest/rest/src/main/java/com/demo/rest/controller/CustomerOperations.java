package com.demo.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.pojo.Customer;
import com.demo.rest.service.CustomerServiceImpl;

@RestController
public class CustomerOperations {
	
	@Autowired
	CustomerServiceImpl service;
	
	@RequestMapping(value="/customer/add", method=RequestMethod.POST)
	public Customer addCustomer(String customerName, long contactNumber, String emailId, String dateOfBirth) {
		Customer customer = new Customer(customerName, contactNumber, emailId, dateOfBirth);
		return service.addCustomer(customer);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET, produces=org.springframework.http.MediaType.ALL_VALUE)
	public Collection<Customer> viewAllCustomers() {
		return service.viewAllCustomers();
	}
	
	@RequestMapping(value="/customer/view/{customerId}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.ALL_VALUE)
	public Customer viewCustomer(@PathVariable int customerId) {
		Customer customer = service.viewCustomer(customerId);
		
		
		
		//customer.add(linkTo(methodOn((CustomerOperations.class).updateCustomer(customer).withSelfRel())));
		return service.viewCustomer(customerId);
	}
	
	@RequestMapping(value="/customer/delete", method=RequestMethod.DELETE, consumes="application/json")
	public String deleteCustomer(@RequestBody Customer customer) {
		return service.deleteCustomer(customer);
	}
	
	@RequestMapping(value="/customer/update", method=RequestMethod.PUT, consumes="application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {	
		return service.updateCustomer(customer);
	}
}
