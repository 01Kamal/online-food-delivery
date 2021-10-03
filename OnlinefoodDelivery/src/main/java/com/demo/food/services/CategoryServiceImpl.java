package com.demo.food.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.ICategoryDao;
import com.demo.food.entity.Category;
import com.demo.food.exception.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	ICategoryDao categoryDao;
	
	public static Logger logger = LogManager.getLogger();

	@Override
	public List<Category> viewAllCategory() {
		return categoryDao.findAll();
	}

	@Override
	public Category addCategory(Category cat) {
		logger.info(cat.getCategoryName());
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
	public Category viewCategoryById(int catId) throws CategoryNotFoundException {
		Optional<Category> c =categoryDao.findById(catId);
		if(!c.isPresent()) {
			throw new CategoryNotFoundException("No such category Found" +catId);
		}
		return c.get();
	}

	@Override
	public Category viewCategoryByName(String categoryName) {
		return categoryDao.findByCategoryName(categoryName);
	}

	
	

}
