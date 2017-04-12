package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Movies;

public interface MovieService {
	public void insert(Movies movie);

	public List<Movies> find(String moviename);
}
