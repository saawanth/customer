package com.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springmvc.model.Movie;
import com.springmvc.model.User;

@Component
public interface MovieService {
	
	public Movie insert(Movie movie);

	public Movie find(String moviename);

	public Movie find(int mid);
	
	public List<Movie> getAll();
	
	public Movie update(Movie movie);
	
	public Movie delete(int mid);
}
