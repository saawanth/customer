 package com.springmvc.model;

/*import java.util.List;*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*import javax.persistence.OneToMany;*/
import javax.persistence.Table;


@Entity
@Table(name="movies", schema="moviestore")
public class Movie {

	@Id
	@Column(name="mid")
	Integer mid;
	
	@Column(name="title")
	String title;
	
	@Column(name="genre")
	String genre;
	
/*	@OneToMany(mappedBy="movie")
	private List<Rating> ratings;*/

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	/*public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}*/
	
	
}
