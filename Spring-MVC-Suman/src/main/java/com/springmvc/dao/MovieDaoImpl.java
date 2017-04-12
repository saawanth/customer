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
import com.springmvc.model.Movies;

@Transactional
public class MovieDaoImpl implements MovieDao{
	@PersistenceContext
	EntityManager entityManager;
	


	@Override
	public void insert(Movies movie) {
	
		entityManager.persist(movie);
	}

	@Override
	public List<Movies> find(String username) {
	//	String user;
		String sql="from Movies m where username= :username";
		Query query=entityManager.createQuery(sql);
		
		query.setParameter("username",username);
		List<Movies> list=query.getResultList();
		return list;
	}
	
}
