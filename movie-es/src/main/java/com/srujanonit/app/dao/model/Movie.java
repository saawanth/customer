package com.srujanonit.app.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="movies_movieid_sequence")
    @SequenceGenerator(name="movies_movieid_sequence", sequenceName="movies_movieid_sequence", allocationSize=1)
	@Column(name = "movieid")
	private long movieid;

	@Column(name = "title")
	private String title;

	@Column(name = "genre")
	private String genre;

	public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
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

}
