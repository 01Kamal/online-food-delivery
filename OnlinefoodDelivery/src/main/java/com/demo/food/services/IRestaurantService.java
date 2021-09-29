package com.demo.food.services;

import java.util.List;

import com.demo.food.entity.Restaurant;

public interface IRestaurantService {

	List<Restaurant> viewAllRestaurants();

	Restaurant addRestaurant(Restaurant res);

	Restaurant removeRestaurant(int restaurantId);

	Restaurant viewRestaurant(String restaurantName);

	Restaurant updateRestaurant(int restaurantId, Restaurant res);

}
