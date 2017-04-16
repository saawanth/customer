package com.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Rating;
import com.springmvc.model.User;

@Transactional
public class RatingDaoImpl implements RatingDao {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void insert(Rating rating) {
	
		entityManager.persist(rating);
	}
	@Override
	public User find(String username) {

		entityManager.find(User.class, username);
		return null;
	}

	
}
