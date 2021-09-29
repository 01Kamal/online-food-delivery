package com.demo.food.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.ICategoryDao;
import com.demo.food.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	ICategoryDao categoryDao;

	@Override
	public List<Category> viewAllCategory() {
		return categoryDao.findAll();
	}

	@Override
	public Category addCategory(Category cat) {
		return categoryDao.save(cat);
	}

	@Override
	public Category removeCategory(int catId) {
		Category c = categoryDao.findById(catId).get();
		categoryDao.deleteById(catId);
		return c;
	}

	@Override
	public Category upadateCategory(int catId, Category cat) {
		Category c = categoryDao.findById(catId).get();
		c.setCategoryName(cat.getCategoryName());
		return categoryDao.save(cat);
	}

	@Override
	public Category viewCategoryById(int catId) {
		Category c =categoryDao.findById(catId).get();
		return c;
	}

	@Override
	public Category viewCategoryByName(String categoryName) {
		return categoryDao.findByCategoryName(categoryName);
	}

	
	

}
