package com.demo.food.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.food.entity.Category;
import com.demo.food.exception.CategoryNotFoundException;
import com.demo.food.services.ICategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	ICategoryService categoryService;
	
	public static Logger logger = LogManager.getLogger();
	
	//view All category
	@GetMapping("/category")
	ResponseEntity<List<Category>> viewAllCategory() {
		return new ResponseEntity<>(categoryService.viewAllCategory(),HttpStatus.OK);
	}
	
	//add Category
	@PostMapping("/category")
		ResponseEntity<Category> addCategory(@RequestBody Category cat) {
			logger.info("Sending Request to the service layer to add Category");
			Category c = categoryService.addCategory(cat);
			logger.debug("Received Response from Service layer");
			return new ResponseEntity<>(c,HttpStatus.CREATED);
		}
	
	//remove Category
	@DeleteMapping("/category/{catId}")
	ResponseEntity<Category> removeCategory(@PathVariable("catId")int catId, @RequestBody Category cat) {
		Category c = categoryService.removeCategory(catId);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	//update Category
	@PutMapping("/category/{catId}")
	ResponseEntity<Category> updateCategory(@PathVariable("catId")int catId, @RequestBody Category cat) {
		Category c = categoryService.upadateCategory(catId, cat);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	//view category by id
	@GetMapping("/category/id/{catId}")
	ResponseEntity<Category> viewCategoryById(@PathVariable int catId, @RequestBody Category cat) throws CategoryNotFoundException {
		Category c = categoryService.viewCategoryById(catId);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	//view category by category name
	@GetMapping("/category/name/{catName}")
	ResponseEntity<Category> viewCategoryByName(@PathVariable("catName")String CategoryName){
		Category c = categoryService.viewCategoryByName(CategoryName);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	

}
