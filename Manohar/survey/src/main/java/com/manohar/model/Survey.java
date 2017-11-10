package com.manohar.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey {
	
	
	@Column(name = "id")
	private int id; 
	
	@Column(name = "survey")
	private String survey;
	
	
	private List<Category> category;

	public Survey() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurvey() {
		return survey;
	}

	public void setSurvey(String survey) {
		this.survey = survey;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey",fetch = FetchType.LAZY)
	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
}
