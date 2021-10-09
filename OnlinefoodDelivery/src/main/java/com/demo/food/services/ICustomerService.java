package com.demo.food.services;

import java.util.List;

import com.demo.food.entity.Customer;
import com.demo.food.exception.CustomerNotFoundException;

public interface ICustomerService {
	
	List<Customer> viewAllCustomers();
	
	Customer addCustomer(Customer customer);
	
	Customer removeCustomer(int customerId);
	
	Customer viewCustomer(String firstName) throws CustomerNotFoundException;
	
	Customer updateCustomer(int customerId, Customer customer);

}
