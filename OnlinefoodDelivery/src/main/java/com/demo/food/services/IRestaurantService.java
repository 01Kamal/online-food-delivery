package com.demo.food.services;

import java.util.List;
import java.util.Optional;

import com.demo.food.entity.Restaurant;
import com.demo.food.exception.RestaurantNotFoundException;

public interface IRestaurantService {

	List<Restaurant> viewAllRestaurants();

	Restaurant addRestaurant(Restaurant res);

	Restaurant removeRestaurant(int restaurantId);

	Restaurant viewRestaurant(String restaurantName) throws RestaurantNotFoundException;

	Restaurant updateRestaurant(int restaurantId, Restaurant res);

	List<Restaurant> viewAllRestaurantByItm(String itemName);

}
