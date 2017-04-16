package com.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.MovieDao;
import com.springmvc.model.Movie;

@Transactional
public class MovieDaoImpl implements MovieDao{
	@PersistenceContext
	EntityManager entityManager;
	


	@Override
	public void insert(Movie movie) {
	
		entityManager.persist(movie);
	}

	@Override
	public List<Movie> find(String moviename) {
	//	String user;
		String sql="from Movie m where title=:title";
		Query query=entityManager.createQuery(sql);
		
		query.setParameter("title",moviename);
		List<Movie> movie=(List<Movie>) query.getResultList();
		return movie;
	}

	@Override
	public Movie find(int mid) {
		String sql="from Movie m where mid=:mid";
		Query query=entityManager.createQuery(sql);
		
		query.setParameter("mid",mid);
		Movie movie=(Movie) query.getSingleResult();
		return movie;
	
	}
	
}
