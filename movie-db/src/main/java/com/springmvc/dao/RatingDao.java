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
	Rating findRating(Integer mid);
}
