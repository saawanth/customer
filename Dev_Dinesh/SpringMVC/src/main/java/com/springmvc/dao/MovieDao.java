package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Movie;

public interface MovieDao {

	public Movie find(String moviename);
	
	public List<Movie> findMovieByGenre(String genre);
	
	public Movie find(int mid);
	
	public List<Movie> findAll();
	
}
