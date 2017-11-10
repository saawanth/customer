package com.manohar.DtoHelper;

import com.manohar.dto.CategoryDto;
import com.manohar.dto.SurveyDto;
import com.manohar.model.Category;
import com.manohar.model.Survey;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SurveyDtoHelper implements DtoHelper<Survey, SurveyDto>{
	private static final Logger LOGGER = Logger.getLogger(SurveyDtoHelper.class);
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
		surveyDto.setSurvey(survey.getSurvey());
		List<Category> categoryList = survey.getCategory();
		List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
		for(Category cat : categoryList) {
			categoryDtoList.add(categoryDtoHelper.buildDto(cat));
		}
		surveyDto.setCategory(categoryDtoList);
		return surveyDto;
	}

	@Override
	public Survey build(SurveyDto surveyDto) {
		
		Survey survey = new Survey();
		survey.setId(surveyDto.getId());
		survey.setSurvey(surveyDto.getSurvey());
	
		return survey;
	}

	@Override
	public List<Survey> build(Iterable<SurveyDto> dtos) {
		
		return null;
	}
}
