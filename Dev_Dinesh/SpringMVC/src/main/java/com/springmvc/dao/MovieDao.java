package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Movie;

public interface MovieDao {

	public Movie find(String moviename);
	
	public List<Movie> findMovieByGenre(String genre);
	
	public Movie find(int mid);
	
	public List<Movie> findAll();
	
	public List<Movie> getMovieByUser(String username);

	public Movie getMovieByMovieId(int id);

	public void addMovie(Movie movie);

	public void deleteMovie(int id);

	public void updateMovie(Movie currentMovie);
	
}
