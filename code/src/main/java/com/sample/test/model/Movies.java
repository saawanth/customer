package com.sample.test.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="movies")
@NamedQuery(name="Movies.findAll", query="SELECT m FROM Movies m")
public class Movies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="movie_genre")
	private String movieGenre;

	@Column(name="movie_name")
	private String movieName;

	//bi-directional many-to-one association to UserRating
	@OneToMany(mappedBy="movies")
	private List<UserRating> userRatings;

	public Movies() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMovieGenre() {
		return this.movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<UserRating> getUserRatings() {
		return this.userRatings;
	}

	public void setUserRatings(List<UserRating> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRating addUserRating(UserRating userRating) {
		getUserRatings().add(userRating);
		userRating.setMovies(this);

		return userRating;
	}

	public UserRating removeUserRating(UserRating userRating) {
		getUserRatings().remove(userRating);
		userRating.setMovies(null);

		return userRating;
	}

}