package com.jittu.dto;

import java.util.List;

import com.jittu.model.QuestionType;

public class QuestionDto {
	private int id;
	private String Question_name;
	private int parent_id;
	private QuestionType question_type;

	
	private List<QuestionChoiceDto> questionChoices;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion_name() {
		return Question_name;
	}
	public void setQuestion_name(String question_name) {
		Question_name = question_name;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public QuestionType getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(QuestionType question_type) {
		this.question_type = question_type;
	}
	public List<QuestionChoiceDto> getQuestionChoices() {
		return questionChoices;
	}
	public void setQuestionChoices(List<QuestionChoiceDto> questionChoices) {
		this.questionChoices = questionChoices;
	}
	
	
	

}
