package com.springmvc.dto;

import java.util.List;

public class UserDto {

	private String username;
	private int age;
	private List<RatingDto> ratings;
	
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
	public List<RatingDto> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingDto> ratings) {
		this.ratings = ratings;
	}
}
