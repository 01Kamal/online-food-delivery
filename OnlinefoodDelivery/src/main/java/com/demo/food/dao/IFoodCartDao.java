package com.demo.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.food.entity.FoodCart;

@Repository
public interface IFoodCartDao extends JpaRepository<FoodCart, Integer> {

}
