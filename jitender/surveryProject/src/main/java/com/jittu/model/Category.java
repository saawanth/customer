package com.jittu.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

//Create the category table by labeling it as @Entity and giving a name for it
@Entity
@Table(name = "category")
public class Category {
	
//	Define column names for each of the variables using @Column(name = "")
	@Column(name = "category_id")
	private int id;
	@Column(name = "category_name")
	private String Category_name;
	
//	Get the survey reference
	private Survey survey;
	
//	Get all the questions from Question class in the form of Set
	private List<Question> questions;
	
//	Generate Constructors
	public Category() {
		
	}
	public Category(String Category_name) {
		this.Category_name = Category_name;
	}
	public Category(String Category_name, Survey survey) {
		this.Category_name = Category_name;
		this.survey = survey;
		
	}
	
//	Generate Getters and Setteres
//	Assign the primary Key by using @Id annotation and auto generate the value
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategory_name() {
		return Category_name;
	}
	public void setCategory_name(String category_name) {
		Category_name = category_name;
	}
	
//	Establish many to one relationship by @ManyToOne annotation and mention the
//	foreign key by @JoinColumn annotation
	@ManyToOne
	@JoinColumn(name = "survey_id")
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
//	Establish One to many relationship with Question by @OneToMany annotation and 
//	mention the mapped by reference
	@OneToMany(mappedBy ="category", cascade = CascadeType.ALL)
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", Category_name=" + Category_name + ", survey=" + survey + ", questions="
				+ questions + "]";
	}
	

}
