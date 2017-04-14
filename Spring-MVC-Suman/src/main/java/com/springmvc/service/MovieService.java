package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Movie;

public interface MovieService {
	public void insert(Movie movie);

	public Movie find(int mid);
}
