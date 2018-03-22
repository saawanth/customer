package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Movie;

public interface MovieService {

	public Movie find(String moviename);
	
	public List<Movie> getAll();
	
	public List<Movie> getMovieByUser(String username);

	public Movie findById(int id);

	public void saveMovie(Movie movie);

	public void updateMovie(Movie currentMovie);


	public void deleteMovieById(int id);
}
