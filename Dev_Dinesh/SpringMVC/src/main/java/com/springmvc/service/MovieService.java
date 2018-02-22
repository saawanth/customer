package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Movie;

public interface MovieService {

	public Movie find(String moviename);
	
	public List<Movie> getAll();
}
