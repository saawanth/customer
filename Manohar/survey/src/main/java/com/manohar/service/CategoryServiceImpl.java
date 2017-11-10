package com.manohar.service;

import com.manohar.model.Category;
import com.manohar.repository.CategoryRepositoy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER = Logger.getLogger(CategoryServiceImpl.class);
    @Autowired
    private CategoryRepositoy categoryRepositoy;


    @Override
    public List<Category> findAll() {
        List<Category> categoryList = categoryRepositoy.findAll();
        return categoryList;
    }

    @Override
    @Transactional(readOnly = true)
    public Category findOne(int id) {
        Category category = categoryRepositoy.findOne(id);
        return category;
    }


}
