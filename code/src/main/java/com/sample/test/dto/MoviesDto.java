package com.sample.test.dto;

import java.util.List;


public class MoviesDto {

	private Long id;
	private String movieName;
	private String movieGenre;
	private List<UserRatingDto> userRatings;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public List<UserRatingDto> getUserRatings() {
		return userRatings;
	}
	public void setUserRatings(List<UserRatingDto> userRatings) {
		this.userRatings = userRatings;
	}
	
	
}
