package com.jittu.dtoHelper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jittu.dto.CategoryDto;
import com.jittu.dto.QuestionDto;
import com.jittu.model.Category;
import com.jittu.model.Question;

@Component
public class CategoryDtoHelper implements DtoHelper<Category, CategoryDto>{
	
	@Autowired
	QuestionDtoHelper questionDtoHelper;

	@Override
	public List<CategoryDto> buildDto(Iterable<Category> models) {
		
		return null;
	}

	@Override
	public CategoryDto buildDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setCategoryName(category.getCategoryName());
		List<Question> questionList = category.getQuestions();
		List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();
		for(Question que : questionList) {
			questionDtoList.add(questionDtoHelper.buildDto(que));
		}
		categoryDto.setQuestions(questionDtoList);
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
