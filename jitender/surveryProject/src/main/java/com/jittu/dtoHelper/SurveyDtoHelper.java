package com.jittu.dtoHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jittu.dto.CategoryDto;
import com.jittu.dto.SurveyDto;
import com.jittu.model.Category;
import com.jittu.model.Survey;

@Component
public class SurveyDtoHelper implements DtoHelper<Survey, SurveyDto>{
	
	@Autowired
	CategoryDtoHelper categoryDtoHelper;

	@Override
	public List<SurveyDto> buildDto(Iterable<Survey> models){
		return null;
	}

	@Override
	public SurveyDto buildDto(Survey survey) {

		SurveyDto surveyDto = new SurveyDto();
		surveyDto.setId(survey.getId());
		surveyDto.setName(survey.getSurvey_name());
		List<Category> categoryList = survey.getCategories();
		List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
		for(Category cat : categoryList) {
			categoryDtoList.add(categoryDtoHelper.buildDto(cat));
		}
		surveyDto.setCategories(categoryDtoList);
		return surveyDto;
	}

	@Override
	public Survey build(SurveyDto surveyDto) {
		
		Survey survey = new Survey();
		survey.setId(surveyDto.getId());
		survey.setSurvey_name(surveyDto.getName());
	
		return survey;
	}

	@Override
	public List<Survey> build(Iterable<SurveyDto> dtos) {
		
		return null;
	}
}
