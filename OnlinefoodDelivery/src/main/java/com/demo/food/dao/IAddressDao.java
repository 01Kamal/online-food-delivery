package com.demo.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.food.entity.Address;

@Repository
public interface IAddressDao extends JpaRepository<Address, Integer> {

}
