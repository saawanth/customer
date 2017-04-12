package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.MovieDao;
import com.springmvc.model.Movies;

public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	@Override
	public void insert(Movies movie) {
		movieDao.insert(movie);
		
	}

	@Override
	public List<Movies> find(String moviename) {
		return movieDao.find(moviename);
		
	}

	
}
