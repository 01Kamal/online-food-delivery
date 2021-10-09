package com.demo.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.food.entity.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

}
