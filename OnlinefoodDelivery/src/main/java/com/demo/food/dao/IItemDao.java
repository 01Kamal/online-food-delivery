package com.demo.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.food.entity.Category;
import com.demo.food.entity.Item;

@Repository
public interface IItemDao extends JpaRepository<Item, Integer> {

	@Query("Select i from Item i where i.itemName like %:itemName%")
	List<Item> viewAllItemsByName(@Param("itemName")String itemName);

	
	@Query("Select i from Item i inner join Category c on i.category.catId = c.catId where c.categoryName=:catName")
	List<Item> viewAllItemsByCat(@Param("catName") String catName);

	
	@Query("Select i from Item i inner join Restaurant r on i.restaurant.restaurantId = r.restaurantId where r.restaurantName=:resName")
	List<Item> viewAllItemsByRes(@Param("resName") String restaurantName);
	
	
}
