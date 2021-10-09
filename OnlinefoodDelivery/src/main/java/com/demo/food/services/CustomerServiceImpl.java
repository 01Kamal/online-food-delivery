package com.demo.food.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.ICustomerDao;
import com.demo.food.entity.Customer;
import com.demo.food.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public List<Customer> viewAllCustomers(){
		return customerDao.findAll();
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);	
	}

	@Override
	public Customer removeCustomer(int customerId) {
		Customer cust = customerDao.findById(customerId).get();
		customerDao.deleteById(customerId);
		return cust;
	}

	@Override
	public Customer viewCustomer(String firstName) throws CustomerNotFoundException {
		Optional<Customer> cust = customerDao.findByFirstName(firstName);
		if(!cust.isPresent()) {
			throw new CustomerNotFoundException(firstName+"Customer not found.Please sign up to continue ");
		}
		return cust.get();
	}
	
	@Override
	public Customer updateCustomer(int customerId, Customer customer) { 
		Customer cust = customerDao.findById(customerId).get();
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setGender(customer.getGender());
		cust.setAge(customer.getAge());
		cust.setMobileNumber(customer.getMobileNumber());
		cust.setCaddress(customer.getCaddress());
		cust.setEmail(customer.getEmail());
		return customerDao.save(cust);
	
	}


}
