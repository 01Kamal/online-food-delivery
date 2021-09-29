package com.demo.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.food.entity.Restaurant;

public interface IRestaurantDao extends JpaRepository<Restaurant, Integer> {

	Restaurant findByRestaurantName(String restaurantName);

}
