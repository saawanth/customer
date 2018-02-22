package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="rating")
public class Rating {
	
	@Id
	@Column(name="rating")
	private float rating;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mid")
	@JsonIgnore
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	@JsonIgnore
	private User user;

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	



	
}
