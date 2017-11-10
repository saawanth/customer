package com.manohar.DtoHelper;

import com.manohar.dto.CategoryDto;
import com.manohar.dto.QuestionDto;
import com.manohar.model.Category;
import com.manohar.model.Question;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class CategoryDtoHelper implements DtoHelper<Category, CategoryDto>{
	private static final Logger LOGGER = Logger.getLogger(CategoryDtoHelper.class);
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
		List<Question> questionList = category.getQuestion();
		List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();
		for(Question question: questionList) {
			questionDtoList.add(questionDtoHelper.buildDto(question));
		}
		categoryDto.setQuestion(questionDtoList);

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
