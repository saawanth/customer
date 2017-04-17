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
import com.springmvc.model.User;

@Transactional
public class MovieDaoImpl implements MovieDao{
	@PersistenceContext
	EntityManager entityManager;
	


	@Override
	public Movie insert(Movie movie) {
	
		entityManager.persist(movie);
		return movie;
	}

	@Override
	public Movie find(String moviename) {
	//	String user;
		String sql="from Movie m where title=:title";
		Query query=entityManager.createQuery(sql);
		
		query.setParameter("title",moviename);
		Movie movie=(Movie) query.getSingleResult();
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
	@Override
	public List<Movie> getAll() {
		Query q = entityManager.createQuery("SELECT x FROM Movie x ");
		return q.getResultList();
	}
	
	@Override
	public Movie update(Movie movie) {
		return entityManager.merge(movie);
	}

	
	public Movie delete(int mid) {
		Movie movie = entityManager.find(Movie.class, mid);
		entityManager.remove(movie);
		return movie;
	}
	
}
