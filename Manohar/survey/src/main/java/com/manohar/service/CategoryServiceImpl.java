package com.manohar.service;

import com.manohar.DtoHelper.CategoryDtoHelper;
import com.manohar.dto.CategoryDto;
import com.manohar.model.Category;
import com.manohar.repository.CategoryRepositoy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepositoy categoryRepositoy;

    @Autowired
    private CategoryDtoHelper categoryDtoHelper;


    @Override
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepositoy.findAll();
        if(null != categoryList) {
            List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
            for(Category category :categoryList) {
                categoryDtoList.add(categoryDtoHelper.buildDto(category));
            }return categoryDtoList;
        }else
            return null;
    }

    @Override
    public CategoryDto findOne(int id) {
        Category category = categoryRepositoy.findOne(id);
        if (!(null == category)) {
            CategoryDto categoryDto = categoryDtoHelper.buildDto(category);
            return categoryDto;
        } else
            return null;
    }

}
