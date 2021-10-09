package com.demo.food.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.food.entity.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByFirstName(String firstName);

}
