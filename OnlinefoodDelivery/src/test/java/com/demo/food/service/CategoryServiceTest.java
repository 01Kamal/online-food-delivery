package com.demo.food.service;


import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
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
		Category cat1 = new Category();
		cat1.setCatId(0);
		cat1.setCategoryName("");
		Category cat2 = new Category();
		cat2.setCatId(0);
		cat2.setCategoryName("");
		List<Category> category = categoryService.viewAllCategory();
		assertEquals(3, category.size());
		assertEquals("", category.get(0).getCategoryName());
		assertEquals("", category.get(1).getCategoryName());
		
	}

	@Disabled
	@Test
	void testAddCategory() {
		Category cat = new Category();
		cat.setCategoryName("");
		Category category = categoryService.addCategory(cat);
		assertEquals(0, category.getCatId());
		assertEquals("",category.getCategoryName());	
	}
	
	@Disabled
	@Test
	void testUpdateCategory() {
		Category cat = new Category();
		cat.setCatId(0);
		cat.setCategoryName("");
		Category category = categoryService.upadateCategory(0, cat);
		assertEquals(0,category.getCatId());
		assertEquals(" ", category.getCategoryName());
	}

	
		
}


