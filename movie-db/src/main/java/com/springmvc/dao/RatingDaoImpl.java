package com.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dto.RatingDto;
import com.springmvc.model.Movie;
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
	
	
	@Override
	public List<Rating> findAll() {
		 Query q = entityManager.createQuery("SELECT x FROM Rating x ");
		    return q.getResultList();
	}
	
	
	@Override
	public Rating findRating(Integer mid) {
		Query q=entityManager.createQuery("select x from Rating x where mid=:mid");
		q.setParameter("mid", mid);
		return (Rating) q.getSingleResult();
	}

	
}
