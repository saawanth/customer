package com.manohar.dto;

import com.manohar.model.QuestionType;

import java.util.List;

public class QuestionDto {

	private int id;
	
	private String question;
	
	private CategoryDto category;
	
	private QuestionType questionType;
	
	private List<QuestionChoiceDto> questionChoice;
	
	private String questionGroup;

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

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public List<QuestionChoiceDto> getQuestionChoice() {
		return questionChoice;
	}

	public void setQuestionChoice(List<QuestionChoiceDto> questionChoice) {
		this.questionChoice = questionChoice;
	}

	public String getQuestionGroup() {
		return questionGroup;
	}

	public void setQuestionGroup(String questionGroup) {
		this.questionGroup = questionGroup;
	}
}
