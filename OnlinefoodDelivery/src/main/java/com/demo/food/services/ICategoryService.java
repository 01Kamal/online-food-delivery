package com.demo.food.services;

import java.util.List;

import com.demo.food.entity.Category;

public interface ICategoryService {

	List<Category> viewAllCategory();

	Category addCategory(Category cat);

	Category removeCategory(int catId);

	Category upadateCategory(int catId, Category cat);

	Category viewCategoryById(int catId);

	Category viewCategoryByName(String categoryName);

	

	

	

}
