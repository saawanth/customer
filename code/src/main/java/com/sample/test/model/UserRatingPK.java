package com.sample.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class UserRatingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;

	@Column(name="movie_id", insertable=false, updatable=false)
	private Integer movieId;

	public UserRatingPK() {
	}
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMovieId() {
		return this.movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserRatingPK)) {
			return false;
		}
		UserRatingPK castOther = (UserRatingPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.movieId.equals(castOther.movieId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.movieId.hashCode();
		
		return hash;
	}
}
