package com.sample.test.dto;

public class UserRatingDto {

	private double rating;
	private Long userId;
	private MovieDto movie;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public MovieDto getMovie() {
		return movie;
	}

	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
