package com.springmvc.dto;

public class RatingDto {
	private int rid;
	private int rate;

	private String username;
	private int age;
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

	//private UserDto user;
	private MovieDto movie;

	/*public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}*/

	public MovieDto getMovie() {
		return movie;
	}

	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
}
