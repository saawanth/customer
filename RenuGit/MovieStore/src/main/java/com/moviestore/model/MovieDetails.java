package com.moviestore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movie_details")
public class MovieDetails {
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieID;
	@Column(name = "movie_title")
	private String movieTitle;
	@Column(name = "genre")
	private String genre;

	@OneToMany(mappedBy = "mSD", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JsonIgnore
	private List<Rating> ratings;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "join_table", joinColumns = @JoinColumn(name = "m_id"), inverseJoinColumns = @JoinColumn(name = "u_id"))
	private List<UserDetails> userDetails;

	public MovieDetails() {
	}

	public MovieDetails(String movieTitle, String genre) {
		this.movieTitle = movieTitle;
		this.genre = genre;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<UserDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	/*
	 * public List<Rating> getRatings() { return ratings; }
	 * 
	 * public void setRatings(List<Rating> ratings) { this.ratings = ratings; }
	 * 
	 * public List<UserDetails> getUserDetails() { return userDetails; }
	 * 
	 * public void setUserDetails(List<UserDetails> userDetails) {
	 * this.userDetails = userDetails; }
	 */

}
