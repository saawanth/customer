package com.springmvc.dao;

import com.springmvc.model.Rating;
import com.springmvc.model.User;

public interface RatingDao {
	 void insert(Rating rating);
	 User find(String username);
}
