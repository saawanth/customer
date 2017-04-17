package com.springmvc.dao;

import java.util.List;

import com.springmvc.dto.RatingDto;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.model.User;

public interface RatingDao {
	
	 void insert(Rating rating);
	 	
	 User find(String username);
	 
	 List<Rating> findAll();
	 
	 List<Rating> findRating(Integer mid);
	 
	 void update(Rating rating);
	 
	 Rating findRatingById(Integer rid);
	
	 void delete(Rating rating);

	List<Rating> findRatingByUsername(String userName);

	List<Movie> findMovieByGenreId(String genre);
}
