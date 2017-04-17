package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.RatingDao;
import com.springmvc.dto.RatingDto;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingDao ratingDao;
	
	MovieService movieService;
	@Override
	public void insert(Rating rating) {
		ratingDao.insert(rating);
		
	}
	
	
	@Override
	public List<Rating> findAll() {
		return ratingDao.findAll();
	}
	
	
	@Override
	public Rating findRating(Integer mid) {
		return ratingDao.findRating(mid);
	}
	
	
	@Override
	public void update(Rating rating) {
		ratingDao.update(rating);
	}
	
	
	@Override
	public Rating findRatingById(Integer rid) {
		
		return ratingDao.findRatingById(rid);
	}
	
	
	
	@Override
	public void delete(Rating rating) {
		ratingDao.delete(rating);
		
	}

}
