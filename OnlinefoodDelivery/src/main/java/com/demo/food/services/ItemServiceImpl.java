package com.demo.food.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.IItemDao;
import com.demo.food.entity.Category;
import com.demo.food.entity.Item;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	IItemDao itemDao;

	@Override
	public Item getItemById(int itemId) {
		Item item = itemDao.findById(itemId).get();
		return item;
	}

	@Override
	public Item addItem(Item item) {
		return itemDao.save(item);
		
	}

	@Override
	public Item removeItem(int itemId) {
		Item itm = itemDao.findById(itemId).get();
		itemDao.deleteById(itemId);
		return itm;
	}

	@Override
	public Item updateItem(int itemId, Item item) {
		Item itm = itemDao.findById(itemId).get();
		itm.setItemName(item.getItemName());
		itm.setQuantity(item.getQuantity());
		itm.setCost(item.getCost());
		return itemDao.save(itm);
	}

	@Override
	public List<Item> viewAllItemsByName(String itemName) {
		return itemDao.viewAllItemsByName(itemName);
	}

	@Override
	public List<Item> viewAllItemsByCat(String catName) {
		return itemDao.viewAllItemsByCat(catName);
	}
		
//	}

	

}