package com.demo.food.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.IRestaurantDao;
import com.demo.food.entity.Restaurant;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	IRestaurantDao restaurantDao;
	
	@Override
	public List<Restaurant> viewAllRestaurants() {
		return restaurantDao.findAll();
	
	}

	@Override
	public Restaurant addRestaurant(Restaurant res) {
		return restaurantDao.save(res);	
	}

	@Override
	public Restaurant removeRestaurant(int restaurantId) {
		Restaurant rest = restaurantDao.findById(restaurantId).get();
		restaurantDao.deleteById(restaurantId);
		return rest;
	}

	@Override
	public Restaurant viewRestaurant(String restaurantName) {
		Restaurant rest = restaurantDao.findByRestaurantName(restaurantName);
		return rest;
	}

	@Override
	public Restaurant updateRestaurant(int restaurantId, Restaurant res) {
		Restaurant rest = restaurantDao.findById(restaurantId).get();
		rest.setRestaurantName(res.getRestaurantName());
		rest.setManagerName(res.getManagerName());
		rest.setContactNumber(res.getContactNumber());
		return restaurantDao.save(rest);
	}

	
}
