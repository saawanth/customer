package com.springmvc.dto;

import javax.persistence.Column;

public class RatingDto {
	private int rid;
	private int rating;

	private String username;
	//private int age;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

/*	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}*/


	//private UserDto user;

	//private MovieDto movie;

	/*public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}*/

/*	public MovieDto getMovie() {
		return movie;
	}

	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}*/

	private int mid;
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getRating() {
		return rating;
	}

	public void setRate(int rate) {
		this.rating = rate;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
}
