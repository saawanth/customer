package com.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating implements Serializable {

	private static final long serialVersionUID = -7977290623821137868L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rid")
	private int rid;

	@Column(name = "rating")
	private int rate;

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "mid")
	private Movie movie;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
