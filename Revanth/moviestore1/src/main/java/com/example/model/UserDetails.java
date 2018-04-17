package com.example.model;

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
@Table(name = "user_details")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "age")
	private int age;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "join_table", joinColumns = @JoinColumn(name = "u_id"), inverseJoinColumns = @JoinColumn(name = "m_id"))
	@JsonIgnore
	private List<MovieDetails> movieDetails;

	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Ratings> ratings;

	public UserDetails() {
	}

	public UserDetails(String name, int age) {
		this.user_name = name;
		this.age = age;

	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<MovieDetails> getMovieDetails() {
		return movieDetails;
	}

	public void setMovieDetails(List<MovieDetails> movieDetails) {
		this.movieDetails = movieDetails;
	}

	public List<Ratings> getRatings() {
		return ratings;
	}

	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}

}
