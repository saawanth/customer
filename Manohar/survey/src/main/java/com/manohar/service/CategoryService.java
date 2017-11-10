package com.manohar.service;



import com.manohar.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public Category findOne(int id);
}
