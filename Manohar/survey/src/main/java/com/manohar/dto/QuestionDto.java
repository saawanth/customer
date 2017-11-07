package com.manohar.dto;

import java.util.List;
import java.util.Set;

public class QuestionDto {

	private int id;
	
	private String question;
	
	private CategoryDto category;
	
	private QuestionTypeDto questionType;
	
	private List<QuestionChoiceDto> questionChoice;
	


	public QuestionDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public QuestionTypeDto getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionTypeDto questionType) {
		this.questionType = questionType;
	}


	public List<QuestionChoiceDto> getQuestionChoice() {
		return questionChoice;
	}

	public void setQuestionChoice(List<QuestionChoiceDto> questionChoice) {
		this.questionChoice = questionChoice;
	}


	
}
