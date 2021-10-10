package com.demo.food.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.food.dao.ICategoryDao;
import com.demo.food.entity.Category;
import com.demo.food.exception.CategoryNotFoundException;
import com.demo.food.services.CategoryServiceImpl;

@ExtendWith(SpringExtension.class)
public class CategoryServiceMockitoTest {
	
	@InjectMocks
	CategoryServiceImpl categoryService;
	
	//creates mock of an Interface
	@MockBean
	ICategoryDao categoryDao;
	
	//Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testViewAllCategory() {
		Category category1 = new Category();
		category1.setCatId(0);
		category1.setCategoryName(null);
		
		Category category2 = new Category();
		category2.setCatId(0);
		category2.setCategoryName(null);
		
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(category1);
		categoryList.add(category2);
		
		Mockito.when(categoryDao.findAll()).thenReturn(categoryList);
		
		List<Category> category = categoryService.viewAllCategory();
		
		assertEquals(2, category.size());
		assertEquals(" ", category.get(0).getCategoryName());
		assertEquals( 0, category.get(0).getCatId());
		assertEquals(" ", category.get(1).getCategoryName());
		assertEquals( 0, category.get(1).getCatId());
		
	}
	
	@Test
	void testAddCategory() {
		Category category = new Category();
		category.setCatId(0);
		category.setCategoryName(null);
		Mockito.when(categoryDao.save(category)).thenReturn(category);
		Category cat = categoryService.addCategory(category);
		assertEquals("",cat.getCategoryName());
	}
	
	@Test
	void testUpdateCategory() {
		Category category = new Category();
		category.setCatId(0);
		category.setCategoryName(null);
		Mockito.when(categoryDao.findById(null)).thenReturn(Optional.of(category));
		Mockito.when(categoryDao.save(category)).thenReturn(category);
		Category cat = categoryService.upadateCategory(0, category);
		assertEquals("",cat.getCategoryName());
	}
	
	@Test
	void testViewCategoryById() throws CategoryNotFoundException {
		    Category category = new Category();
		    category.setCatId(0);
		    category.setCategoryName(null);
		    Mockito.when(categoryDao.findById(null)).thenReturn(Optional.of(category));
		    Category cat = categoryService.viewCategoryById(0);
		    assertEquals(0,cat.getCategoryName());
	}
	@Test
	void testRemoveCategory() {
		Category category = new Category();
		category.setCatId(0);
		category.setCategoryName("");
		Mockito.when(categoryDao.findById(null)).thenReturn(Optional.of(category));
		categoryDao.deleteById(null);
		Category cat = categoryService.removeCategory(0);
		assertEquals("",cat.getCategoryName());
		
	}

}
