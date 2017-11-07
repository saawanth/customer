package com.manohar.dto;

public class QuestionChoiceDto {
	
	private int id;
	
	private QuestionDto question;
	
	private String choice;
	
	public QuestionChoiceDto() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public QuestionDto getQuestion() {
		return question;
	}

	public void setQuestion(QuestionDto question) {
		this.question = question;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
}
