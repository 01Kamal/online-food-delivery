package com.demo.food.services;

import java.util.List;

import com.demo.food.entity.FoodCart;

public interface IFoodCartService {
	
	FoodCart addItemToCart(int cartId,int itemId);
	FoodCart reduceQuantity(int cartId,int itemId,int quantity);
    FoodCart removeItem(int cartId, int itemId);
    FoodCart clearCart(int cartId);
	FoodCart increaseQuantity(int cartId, int itemId, int quantity);
    List<FoodCart> getAllItems();

}
