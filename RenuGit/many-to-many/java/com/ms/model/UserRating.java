package com.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class UserRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private int ratingID;

	@JoinColumn(name="m_id")
	private MovieDetails movieDetails;

	private UserDetails userDetails;

	private int rating;

	public UserRating() {
	}

	public UserRating(int ratingID, MovieDetails movieDetails, UserDetails userDetails, int rating) {
		super();
		this.ratingID = ratingID;
		this.movieDetails = movieDetails;
		this.userDetails = userDetails;
		this.rating = rating;
	}

	public int getRatingID() {
		return ratingID;
	}

	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}

	public MovieDetails getMovieDetails() {
		return movieDetails;
	}

	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "UserRating [ratingID=" + ratingID + ", rating=" + rating + "]";
	}

}
