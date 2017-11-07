package com.manohar.DtoHelper;

import java.util.List;

import com.manohar.dto.CategoryDto;
import com.manohar.model.Category;
import org.springframework.stereotype.Component;



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
		categoryDto.setCategoryName(category.getCategoryName());
		return categoryDto;
	}

	@Override
	public Category build(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCategoryName(categoryDto.getCategoryName());
		return category;
	}

	@Override
	public List<Category> build(Iterable<CategoryDto> dtos) {		// TODO Auto-generated method stub
		return null;
	}

}
