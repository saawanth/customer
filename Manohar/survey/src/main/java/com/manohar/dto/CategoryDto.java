package com.manohar.dto;

import java.util.List;
import java.util.Set;

public class CategoryDto {
	
	private int id;
	
	private String categoryName;
	
	private SurveyDto survey;
	
	private List<QuestionDto> question;
	
	
	public CategoryDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public SurveyDto getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyDto survey) {
		this.survey = survey;
	}

	public List<QuestionDto> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionDto> question) {
		this.question = question;
	}
	
	
	

}
