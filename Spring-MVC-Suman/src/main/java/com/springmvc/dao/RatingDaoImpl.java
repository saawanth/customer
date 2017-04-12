package com.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Ratings;

@Transactional
public class RatingDaoImpl implements RatingDao {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void insert(Ratings rating) {
	
		entityManager.persist(rating);
	}

}
