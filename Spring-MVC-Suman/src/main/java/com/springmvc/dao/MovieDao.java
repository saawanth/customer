package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Movies;
import com.springmvc.model.User;

public interface MovieDao {
	public void insert(Movies movie);

	public List<Movies> find(String moviename);
}
