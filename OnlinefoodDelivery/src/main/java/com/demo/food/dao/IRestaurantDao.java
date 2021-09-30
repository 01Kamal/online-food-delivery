package com.demo.food.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.food.entity.Item;
import com.demo.food.entity.Restaurant;

@Repository
public interface IRestaurantDao extends JpaRepository<Restaurant, Integer> {

	Optional<Restaurant> findByRestaurantName(String restaurantName);
	@Query("Select r from Restaurant r inner join r.item ra where ra.itemName =:itemName")
	List<Restaurant> viewAllRestaurantByItm(@Param("itemName")String itemName);
	
//	@Query("Select i from Item i inner join Category c on i.category.catId = c.catId where c.categoryName=:catName")
//	List<Item> viewAllItemsByCat(@Param("catName") String catName);

}
