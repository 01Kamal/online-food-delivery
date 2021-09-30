package com.demo.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.food.entity.Item;
import com.demo.food.entity.Restaurant;
import com.demo.food.exception.RestaurantNotFoundException;
import com.demo.food.services.IRestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	IRestaurantService restaurantService;
	
	//view all restaurants
	@GetMapping("/restaurant")
	ResponseEntity<List<Restaurant>> viewAllRestaurants() {
		return new ResponseEntity<>(restaurantService.viewAllRestaurants(), HttpStatus.OK);
	}
	
	//Add new restaurant
	@PostMapping("/restaurant")
	ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant res){
		Restaurant rest=restaurantService.addRestaurant(res);
		return new ResponseEntity<>(rest, HttpStatus.CREATED);
	}
	
	//delete restaurant information
	@DeleteMapping("/restaurant/{resid}")
	ResponseEntity<Restaurant> removeRestaurant(@PathVariable("resid") int restaurantId) {
		Restaurant rest = restaurantService.removeRestaurant(restaurantId);
		return new ResponseEntity<>(rest, HttpStatus.OK);
	}
	
	//View Restaurant based on Restaurant Name
	@GetMapping("/restaurant/{name}")
	ResponseEntity<Restaurant> viewRestaurant(@PathVariable("name") String restaurantName) throws RestaurantNotFoundException {
		Restaurant rest = restaurantService.viewRestaurant(restaurantName);
		return new ResponseEntity<>(rest, HttpStatus.OK);
	}
	
	//Update Restaurant Details
	@PutMapping("/restaurant/{resid}")
	ResponseEntity<Restaurant> updateRestaurant(@PathVariable("resid")int restaurantId, @RequestBody Restaurant res) {
		Restaurant rest = restaurantService.updateRestaurant(restaurantId, res);
		return new ResponseEntity<>(rest,HttpStatus.CREATED);
	}
	
	//view Restaurant Name based on Item Name
	@GetMapping("/restaurant/item/{itm}")
	ResponseEntity<List<Restaurant>> viewAllRestaurantByItm(@PathVariable("itm")String itemName){
		List<Restaurant> res = restaurantService.viewAllRestaurantByItm(itemName);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

//	public List<Restaurant> viewNearByRestaurant(String location);

}
