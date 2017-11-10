package com.jittu.service;

import java.util.List;

import com.jittu.model.Category;


public interface CategoryService {
	public List<Category> findAll();

	  public Category findOne(int id);

}
