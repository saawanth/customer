package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Movie;
import com.springmvc.model.User;

public interface MovieDao {
	public void insert(Movie movie);

	public Movie find(int mid);
}
