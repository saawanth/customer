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
	
	public List<Movie> getMovieByUser(String username) {
		return(List<Movie>) movieDao.getMovieByUser(username);
	}
	public Movie findById(int id) {
		return (Movie) movieDao.getMovieByMovieId(id);
	}
	public void saveMovie(Movie movie) {
		movieDao.addMovie(movie);
	}
	public void updateMovie(Movie currentMovie) {
		movieDao.updateMovie(currentMovie);
	}
	public void deleteMovieById(int id) {
		movieDao.deleteMovie(id);
		
	}
	

}
