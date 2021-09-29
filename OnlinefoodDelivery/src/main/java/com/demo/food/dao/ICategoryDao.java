package com.demo.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.food.entity.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

}
