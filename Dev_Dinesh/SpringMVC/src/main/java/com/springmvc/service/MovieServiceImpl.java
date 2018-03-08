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
	
	public Movie find(String moviename) {
		return movieDao.find(moviename);
		
	}
	public List<Movie> getAll() {
		return(List<Movie>) movieDao.findAll();
	}

}
