package org.movie.store.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "movie")
@NamedQuery(name = "movie.findAll", query = "SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private Genre genre;

	@Column(name = "name")
	private String name;
		
	// bi-directional many-to-one association to UserRating
	@OneToMany(mappedBy = "movie")
	private List<UserRating> userRatings;

	// @Column(name = "rating")
	@Transient
	private Double avgRating;

	public Movie() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRating> getUserRatings() {
		return this.userRatings;
	}

	public void setUserRatings(List<UserRating> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRating addUserRating(UserRating userRating) {
		getUserRatings().add(userRating);
		userRating.setMovie(this);

		return userRating;
	}

	public UserRating removeUserRating(UserRating userRating) {
		getUserRatings().remove(userRating);
		userRating.setMovie(null);

		return userRating;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
}