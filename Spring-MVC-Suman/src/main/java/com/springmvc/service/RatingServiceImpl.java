package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.RatingDao;
import com.springmvc.model.Rating;
@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingDao ratingDao;
	@Override
	public void insert(Rating rating) {
		ratingDao.insert(rating);
		
	}

}
