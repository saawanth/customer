package com.jittu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jittu.dto.CategoryDto;
import com.jittu.dtoHelper.CategoryDtoHelper;
import com.jittu.model.Category;
import com.jittu.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryDtoHelper categoryDtoHelper;

	@Override
	public List<CategoryDto> findAll() {
		List<Category> categoryList = categoryRepository.findAll();
		if(!(null == categoryList)) {
			List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
			for(Category category :categoryList) {
				categoryDtoList.add(categoryDtoHelper.buildDto(category));
			}return categoryDtoList;
		}else
		return null;
		
	}

}
