package com.jittu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jittu.model.Category;
import com.jittu.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		List<Category> categoryList = categoryRepository.findAll();
		return categoryList;
	}

	@Override
	public Category findOne(int id) {
		Category category = categoryRepository.getOne(id);
		return category;
	}

}
