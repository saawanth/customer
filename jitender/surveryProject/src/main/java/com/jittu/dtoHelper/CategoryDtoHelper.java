package com.jittu.dtoHelper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jittu.dto.CategoryDto;
import com.jittu.model.Category;

@Component
public class CategoryDtoHelper implements DtoHelper<Category, CategoryDto>{

	@Override
	public List<CategoryDto> buildDto(Iterable<Category> models) {
		
		return null;
	}

	@Override
	public CategoryDto buildDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setCategory_name(category.getCategory_name());
		return categoryDto;
	}

	@Override
	public Category build(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCategory_name(categoryDto.getCategory_name());
		return category;
	}

	@Override
	public List<Category> build(Iterable<CategoryDto> dtos) {		// TODO Auto-generated method stub
		return null;
	}

}
