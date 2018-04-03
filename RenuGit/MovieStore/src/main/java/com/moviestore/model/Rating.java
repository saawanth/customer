package com.moviestore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ratings")
public class Rating {
	@Id
	@Column(name = "r_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingID;
	// @Column(name = "m_id")
	// private int mID;
	// @Column(name = "u_id")
	// private int uID;
	@Column(name = "movie_rating")
	private float rating;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "m_id")
	private MovieDetails mSD;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "u_id")
	@JsonIgnore
	private UserDetails uSD;

	public Rating() {

	}

	public Rating(float rating) {
		this.rating = rating;
	}

	public int getRatingID() {
		return ratingID;
	}

	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public MovieDetails getMovieDetails() {
		return mSD;
	}

	public void setMovieDetails(MovieDetails movieDetails) {
		this.mSD = movieDetails;
	}

	public UserDetails getUserDetails() {
		return uSD;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.uSD = userDetails;
	}

	public MovieDetails getmSD() {
		return mSD;
	}

	public void setmSD(MovieDetails mSD) {
		this.mSD = mSD;
	}

	public UserDetails getuSD() {
		return uSD;
	}

	public void setuSD(UserDetails uSD) {
		this.uSD = uSD;
	}

}
