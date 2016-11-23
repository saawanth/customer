package org.movie.store.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class UserRatingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private long userId;

	@Column(name="movie_id", insertable=false, updatable=false)
	private long movieId;

	public UserRatingPK() {
	}
	

	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public long getMovieId() {
		return movieId;
	}


	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (movieId ^ (movieId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRatingPK other = (UserRatingPK) obj;
		if (movieId != other.movieId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	
}
