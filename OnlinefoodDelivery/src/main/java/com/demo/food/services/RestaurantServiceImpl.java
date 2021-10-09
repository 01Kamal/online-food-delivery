package com.demo.food.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.IRestaurantDao;
import com.demo.food.entity.Restaurant;
import com.demo.food.exception.RestaurantNotFoundException;

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
	public Restaurant viewRestaurant(String restaurantName) throws RestaurantNotFoundException {
		Optional<Restaurant> rest = restaurantDao.findByRestaurantName(restaurantName);
		if(!rest.isPresent()) {
			throw new RestaurantNotFoundException("Restaurant Not Found with such Name" +restaurantName);
		}
		return rest.get();
	}

	@Override
	public Restaurant updateRestaurant(int restaurantId, Restaurant res) {
		Restaurant rest = restaurantDao.findById(restaurantId).get();
		rest.setRestaurantName(res.getRestaurantName());
		rest.setManagerName(res.getManagerName());
		rest.setContactNumber(res.getContactNumber());
		return restaurantDao.save(rest);
	}

	@Override
	public List<Restaurant> viewAllRestaurantByItm(String itemName) {
		return restaurantDao.viewAllRestaurantByItm(itemName);
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		Optional<Restaurant> restaurant = restaurantDao.findById(restaurantId);
		return restaurant.get();
	}

//	@Override
//	public List<Restaurant> viewNearByRestaurant(String street) {
//		return restaurantDao.viewNearByRestaurant(street);
//	}

	
}
