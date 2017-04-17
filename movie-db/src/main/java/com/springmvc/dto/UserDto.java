package com.springmvc.dto;

import java.util.List;

public class UserDto {
	private String name;
	private int age;
	private List<RatingDto> ratings;

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

	public List<RatingDto> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingDto> ratings) {
		this.ratings = ratings;
	}
}
