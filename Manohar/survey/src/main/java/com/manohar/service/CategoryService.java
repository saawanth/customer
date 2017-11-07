package com.manohar.service;

import com.manohar.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> findAll();
    public CategoryDto findOne(int id);
}
