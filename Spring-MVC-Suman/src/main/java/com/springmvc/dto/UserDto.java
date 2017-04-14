package com.springmvc.dto;

import java.util.List;

import javax.persistence.Id;

import com.springmvc.model.Rating;

public class UserDto {

	@Id
	private String name;
	private int age;
	private List<Rating> ratings;
	
	
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
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}
