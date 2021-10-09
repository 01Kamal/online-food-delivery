package com.demo.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.food.entity.OrderDetails;

public interface IOrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

}
