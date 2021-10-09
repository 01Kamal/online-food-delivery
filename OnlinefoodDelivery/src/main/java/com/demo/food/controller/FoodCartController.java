package com.demo.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.food.entity.FoodCart;
import com.demo.food.services.IFoodCartService;

@CrossOrigin
@RestController
public class FoodCartController {
	
	@Autowired
    IFoodCartService cartService;
	
	//Adding items To Cart
	@PostMapping("/cart/{cartId}/item/{itemId}")
	ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") int CartId , @PathVariable("itemId") int  itemId)
	{
	 FoodCart crt=cartService.addItemToCart(CartId,itemId);
	return new ResponseEntity<>(crt,HttpStatus.OK);
	}
	
	//deleting items from cart
	@DeleteMapping("/delete/{cartId}/item/{itemId}")
	ResponseEntity<FoodCart> removeItem(@PathVariable("cartId") int CartId , @PathVariable("itemId") int  itemId)
	{
	 FoodCart crt=cartService.removeItem(CartId,itemId);
	 return new ResponseEntity<>(crt,HttpStatus.OK);
	}
	
	//removing cart
	@DeleteMapping("/deletecart/{cartId}")
	ResponseEntity<FoodCart> clearCart(@PathVariable("cartId") int CartId)
	{
	 FoodCart crt=cartService.clearCart(CartId);
	 return new ResponseEntity<>(crt,HttpStatus.OK);
	}
	
	//increase quantity
	@PutMapping("/increase/{cartId}/item/{itemId}/{quantity}")
	ResponseEntity<FoodCart> increaseQuantity(@PathVariable("cartId") int cartId,@PathVariable("itemId") int itemId ,  @PathVariable("quantity") int quantity)
	{
	 FoodCart cart=cartService.increaseQuantity(cartId,itemId,quantity);
	 return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	//decrease quantity
	@PutMapping("/decrease/{cartId}/item/{itemId}/{quantity}")
	ResponseEntity<FoodCart> reduceQuantity(@PathVariable("cartId") int cartId,@PathVariable("itemId") int itemId ,  @PathVariable("quantity") int quantity)
	{
	 FoodCart cart=cartService.reduceQuantity(cartId,itemId,quantity);
	 return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	//view cart items
	@GetMapping("/cart")
	ResponseEntity <List<FoodCart>> getAllItems()
	   {
		  return new ResponseEntity<>(cartService.getAllItems(),HttpStatus.OK);
	  }

}
