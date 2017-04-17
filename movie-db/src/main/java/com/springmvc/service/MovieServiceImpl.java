package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.MovieDao;
import com.springmvc.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	@Override
	public Movie insert(Movie movie) {
		return movieDao.insert(movie);
		
	}

	@Override
	public Movie find(String moviename) {
		return movieDao.find(moviename);
	
	}

	@Override
	public Movie find(int mid) {
		
		return movieDao.find(mid);
	}
	
	
	@Override
	public List<Movie> getAll() {
		
		return movieDao.getAll();
	}

	@Override
	public Movie update(Movie movie) {
		
		return movieDao.update(movie);
	}

	
	@Override
	public Movie delete(int mid) {
		return movieDao.delete(mid);
	}
	
}
