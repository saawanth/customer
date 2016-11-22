package com.sample.test.dto;

import com.sample.test.model.Genre;

public class MovieDto {

	private Long id;
	private String name;
	private Genre genre;
	private double avgRating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
