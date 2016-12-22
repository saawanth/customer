package com.myretail.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserRatingDto {

	private Long userId;
	private ProductDto movie;
	private Double rating;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ProductDto getMovie() {
		return movie;
	}

	public void setMovie(ProductDto movie) {
		this.movie = movie;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
}
