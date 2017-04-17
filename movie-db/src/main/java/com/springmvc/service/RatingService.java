package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.RatingDto;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;

public interface RatingService {

	 void insert(Rating rating);

	List<Rating> findAll();
	
	Rating findRating(Integer mid);

	void update(Rating rating);
	 
	Rating findRatingById(Integer rid);

	void delete(Rating rating);
}
