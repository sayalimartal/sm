package com.demo.rest.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.demo.rest.controller.CustomerOperations;
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
	
	

	private static Map<Integer,Customer> customerList;
	
	static {
		customerList = new HashMap<>();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		Link link=ControllerLinkBuilder(CustomerOperations.class)
				.slash("customer").slash("delete");
		customerList.put(customer.getCustomerId(),customer);
		return customer;
	}

	@Override
	public Collection<Customer> viewAllCustomers() {
		return customerList.values();
	}

	@Override
	public String deleteCustomer(Customer customer) {
			for(Customer cust:customerList.values()) {
				if(cust.getCustomerId()==customer.getCustomerId()) {
					customerList.remove(cust.getCustomerId());
					break;
				}
			}
			return "Customer with id "+customer.getCustomerId()+" has been deleted";
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		deleteCustomer(customer);
		customerList.put(customer.getCustomerId(),customer);
		return customer;
	}
	
	@Override
	public Customer viewCustomer(int customerId) {
		Customer customer = null;
		for(Customer cust:customerList.values()) {
			if(cust.getCustomerId()==customerId) {
				customer=cust;
				break;
			}
		}
		return customer;
		}

}
