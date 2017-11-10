package com.manohar.model;

import javax.persistence.*;


@Entity
@Table(name = "questionchoice")
public class QuestionChoice {
	
	
	@Column(name = "id")
	private int id;
	

	private Question question;
	
	@Column(name = "choice")
	private String choice;

	public QuestionChoice() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
}
