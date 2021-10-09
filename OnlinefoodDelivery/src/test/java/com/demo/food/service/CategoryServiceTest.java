package com.demo.food.service;


import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.food.entity.Category;
import com.demo.food.services.ICategoryService;

@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	ICategoryService categoryService;
	
	@Test 
	void testViewAllCategory() {
		List<Category> category = categoryService.viewAllCategory();
		assertEquals(3, category.size());
		assertEquals("Dessert", category.get(0).getCategoryName());
		
	}

	@Test
	void testAddCategory() {
		
	}

	
		
}


