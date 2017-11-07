package com.arun.dto;

import java.util.List;
import java.util.Set;

import com.arun.model.Category;

public class SurveyDto {
	private int id;
	
	private String name;
	
	private List<CategoryDto> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDto> categories) {
		this.categories = categories;
	}
	
	

}
