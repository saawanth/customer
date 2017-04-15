package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.MovieDao;
import com.springmvc.model.Movie;

public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	@Override
	public void insert(Movie movie) {
		movieDao.insert(movie);
		
	}

	@Override
	public List<Movie> find(String moviename) {
		return movieDao.find(moviename);
	
	}

	@Override
	public Movie find(int mid) {
		
		return movieDao.find(mid);
	}

	
}
