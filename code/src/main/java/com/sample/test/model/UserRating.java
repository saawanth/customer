package com.sample.test.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="user_ratings")
@NamedQuery(name="UserRating.findAll", query="SELECT u FROM UserRating u")
public class UserRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRatingPK id;

	private double rating;

	//bi-directional many-to-one association to Movy
	@ManyToOne
	@JoinColumn(name="movie_id",referencedColumnName = "id",insertable= false, updatable=false)
	private Movies movies;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName = "id",insertable= false, updatable=false)
	private Users user;

	public UserRating() {
	}

	public UserRatingPK getId() {
		return this.id;
	}

	public void setId(UserRatingPK id) {
		this.id = id;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Movies getMovies() {
		return this.movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
