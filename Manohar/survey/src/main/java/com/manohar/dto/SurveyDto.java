package com.manohar.dto;

import java.util.List;
import java.util.Set;

public class SurveyDto {
	
	private int id;
	
	private String survey;
	
	private List<CategoryDto> category;
	
	
	public SurveyDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurvey() {
		return survey;
	}

	public void setSurvey(String survey) {
		this.survey = survey;
	}

	public List<CategoryDto> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryDto> category) {
		this.category = category;
	}

	
}
