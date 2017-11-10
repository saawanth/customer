package com.arun.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

//Create a table by labeling it as @Entity and giving the Table a name
@Entity
@Table(name = "survey")
public class Survey {
	
//	Define Column names for each of the variables by @Column
	@Column(name = "id")
	private int id;
	@Column(name = "survey_name")
	private String Survey_name;
	
//	Get all the categories in the form of Set
	@Autowired
	private List<Category> categories;
	
//	Generate constructors
	public Survey() {
	}

	public Survey(String Survey_name) {
		this.Survey_name = Survey_name;
	}

public Survey(int id, String survey_name, List<Category> categories) {
		this.id = id;
		this.Survey_name = survey_name;
		this.categories = categories;
	}

	//	Generate Getters and setters for all of the variables
//	Define id as primary key by giving the annotation @Id and aut generating it by @GeneratedValue
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurvey_name() {
		return Survey_name;
	}

	public void setSurvey_name(String survey_name) {
		Survey_name = survey_name;
	}

//	Define one to many mapping with category using annotation and mappedBy the reference of survey
	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
