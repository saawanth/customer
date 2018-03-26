package com.springmvc.model;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users",schema="moviestore") 
public class User {

	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "age")
	private int age;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	@JoinTable(name = "join_table", joinColumns= @JoinColumn(name="username"), inverseJoinColumns = @JoinColumn(name = "mid"))
	@JsonIgnore
	private List<Movie> movie;

	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore 
	private List<Rating> ratings;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
}
