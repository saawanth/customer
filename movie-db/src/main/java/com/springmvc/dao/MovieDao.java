package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Movie;
import com.springmvc.model.User;

public interface MovieDao {
	public Movie insert(Movie movie);

	public Movie find(String moviename);

	public Movie find(int mid);
	
	List<Movie> getAll();

	public Movie update(Movie movie);

	public Movie delete(int mid);
}
