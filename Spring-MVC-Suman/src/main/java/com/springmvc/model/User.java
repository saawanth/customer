package com.springmvc.model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.mapping.Set;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name="username")
	private String name;
	
	@Column(name="age")
	private int age;
	
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private ArrayList<Ratings> ratingList;
	
	
	public ArrayList<Ratings> getRatingList() {
		return ratingList;
	}
	public void setRatingList(ArrayList<Ratings> ratingList) {
		this.ratingList = ratingList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}
