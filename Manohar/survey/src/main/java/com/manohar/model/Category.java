package com.manohar.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "category")
public class Category {
	
	
	@Column(name = "id")
	private int id;
	
	
	private Survey survey;
	
	@Column(name = "categoryName")
	private String categoryName;
	
	
	private List<Question> question;

	public Category() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_id")
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	
	
}
