package com.demo.food.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.demo.food.entity.Category;
import com.demo.food.entity.Item;
import com.demo.food.exception.ItemNotFoundException;
import com.demo.food.services.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	IItemService itemService;
	
	//View item
	@GetMapping("/item/{itemId}")
	ResponseEntity<Item> viewItem(@PathVariable("itemId") int itemId) throws ItemNotFoundException {
		Item item = itemService.getItemById(itemId);
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	//add item
	@PostMapping("/item")
	ResponseEntity<Item> addItem(@Valid Item item) {
		Item itm = itemService.addItem(item);
		return new ResponseEntity<>(itm,HttpStatus.CREATED);
	}
	
	//remove Item
	@DeleteMapping("/item/{itemId}")
		ResponseEntity<Item> removeItem(@PathVariable("itemId")int itemId) {
		Item itm = itemService.removeItem(itemId);
		return new ResponseEntity<>(itm,HttpStatus.OK);
	} 
	
	//update Item
	@PutMapping("/item/{itemId}")
		ResponseEntity<Item> updateItem(@PathVariable("itemId")int itemId, @RequestBody Item item) {
		Item itm = itemService.updateItem(itemId, item);
		return new ResponseEntity<>(itm,HttpStatus.OK);
	}
	
	//view Items by name
	@GetMapping("/item/name/{itemName}")
	ResponseEntity<List<Item>> viewAllItemsByName(@PathVariable("itemName") String itemName){
		List<Item> itm = itemService.viewAllItemsByName(itemName);
		return new ResponseEntity<>(itm,HttpStatus.OK);
	}
	//view Items by category
	@GetMapping("/item/category/{cat}")
	ResponseEntity<List<Item>> viewAllItemsByCat(@PathVariable("cat") String categoryName){
		List<Item> itm = itemService.viewAllItemsByCat(categoryName);
		return new ResponseEntity<>(itm,HttpStatus.OK);
		
	}
	
	//view Items by restaurant
	@GetMapping("/item/restaurant/{res}")
	ResponseEntity<List<Item>> viewAllItemsByRes(@PathVariable("res")String restaurantName){
		List<Item> itm = itemService.viewAllItemsByRes(restaurantName);
		return new ResponseEntity<>(itm,HttpStatus.OK);
	}


}
