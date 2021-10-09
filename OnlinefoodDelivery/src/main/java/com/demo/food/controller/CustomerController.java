package com.demo.food.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.food.entity.Customer;
import com.demo.food.exception.CustomerNotFoundException;
import com.demo.food.services.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	public static Logger logger = LogManager.getLogger();
	
	//view all Customers
	
	@GetMapping("/customer")
	ResponseEntity<List<Customer>> viewAllCustomers() {
		return new ResponseEntity<>(customerService.viewAllCustomers(),HttpStatus.OK);
	}
	
	//Add new customer
	
	@PostMapping("/customer")
	ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer cust=customerService.addCustomer(customer);
		return new ResponseEntity<>(cust,HttpStatus.CREATED);
		
	}
	
	//delete customer information
	
	@DeleteMapping("/customer/{custid}")
	ResponseEntity<Customer> removeCustomer(@PathVariable("custid")int customerId){
		Customer cust=customerService.removeCustomer(customerId);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	//view customer 
	
	@GetMapping("/customer/{name}")
	ResponseEntity<Customer> viewCustomer(@PathVariable("name") String firstName) throws CustomerNotFoundException{
		Customer cust=customerService.viewCustomer(firstName);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	//update Customer details
	
	@PutMapping("/customer/{custid}")
	ResponseEntity<Customer> updateCustomer(@PathVariable("custid")int customerId, @RequestBody Customer customer){
		Customer cust=customerService.updateCustomer(customerId, customer);
		return new ResponseEntity<>(cust,HttpStatus.CREATED);
	}
	

}
