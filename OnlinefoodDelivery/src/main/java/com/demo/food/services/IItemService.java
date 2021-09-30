package com.demo.food.services;

import java.util.List;

import com.demo.food.entity.Category;
import com.demo.food.entity.Item;
import com.demo.food.exception.ItemNotFoundException;

public interface IItemService {

	Item getItemById(int itemId) throws ItemNotFoundException;

	Item addItem(Item item);

	Item removeItem(int itemId);

	Item updateItem(int itemId, Item item);

	List<Item> viewAllItemsByName(String itemName);

	List<Item> viewAllItemsByCat(String catName);

	List<Item> viewAllItemsByRes(String restaurantName);

}
