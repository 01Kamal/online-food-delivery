package com.demo.food.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.IFoodCartDao;
import com.demo.food.dao.IItemDao;
import com.demo.food.entity.FoodCart;
import com.demo.food.entity.Item;

@Service
public class FoodCartServiceImpl implements IFoodCartService {

	@Autowired
	IFoodCartDao cartDao;
	@Autowired
    IItemDao itemDao;
	
	@Override
	public FoodCart addItemToCart(int cartId,int itemId) {
	 FoodCart cart= cartDao.findById(cartId).get();
	 Item item =itemDao.findById(itemId).get();
	 cart.getItems().add(item);
	 return cartDao.save(cart);
	}

	@Override
	public FoodCart increaseQuantity(int cartId,int itemId,int quantity)
	{
	FoodCart cart=cartDao.findById(cartId).get(); 
	Item item =itemDao.findById(itemId).get();
    item.setQuantity(quantity+1);
	return cartDao.save(cart);
	}

    @Override
	public FoodCart removeItem(int cartId, int itemId)
	{FoodCart cart=cartDao.findById(cartId).get();                      ;
	itemDao.deleteById(itemId);
	return cart;
	}

	@Override
	public FoodCart clearCart(int cartId)
	{
	FoodCart cart= cartDao.findById(cartId).get();
	cartDao.deleteById(cartId);
	return cart;
	}

    @Override
	public FoodCart reduceQuantity(int cartId, int itemId, int quantity) {
		FoodCart cart=cartDao.findById(cartId).get(); 
		Item item =itemDao.findById(itemId).get();
	    item.setQuantity(quantity-1);
		return cartDao.save(cart);
	}

	@Override
	public List<FoodCart> getAllItems() {
		return cartDao.findAll();
	}
}
