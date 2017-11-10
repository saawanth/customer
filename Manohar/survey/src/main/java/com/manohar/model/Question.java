package com.manohar.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "question")
public class Question {
	
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "question")
	private String question;

	@Column
	private String questionGroup;
	
	private Category category;
	
	@Column(name = "question_type")
	@Enumerated(EnumType.STRING)
	private QuestionType questionType;

	private List<QuestionChoice> questionChoiceList;
	public Question() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public String getQuestionGroup() { return questionGroup; }

	public void setQuestionGroup(String questionGroup) { this.questionGroup = questionGroup; }

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	public List<QuestionChoice> getQuestionChoiceList() {
		return questionChoiceList;
	}

	public void setQuestionChoiceList(List<QuestionChoice> questionChoiceList) {
		this.questionChoiceList = questionChoiceList;
	}
}
