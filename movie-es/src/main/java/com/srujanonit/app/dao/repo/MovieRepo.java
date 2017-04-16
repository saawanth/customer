package com.srujanonit.app.dao.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.srujanonit.app.dao.model.Movie;


@Repository
public class MovieRepo implements BaseRepo<Long, Movie>{

	@PersistenceContext
	EntityManager entityManager;
	
	
	
	public Movie save(Movie entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	public Movie find(long id) {
		// TODO Auto-generated method stub
		Movie movie = entityManager.find(Movie.class, id);	
		return movie;
	}

	public Movie update(Movie entity) {
		// TODO Auto-generated method stub
		return entityManager.merge(entity);
	}

	public Movie delete(Long id) {
		// TODO Auto-generated method stub
		Movie movie = entityManager.find(Movie.class, id);	
		entityManager.remove(movie);
		return movie;
	}

	public List<Movie> getAll() {
		// TODO Auto-generated method stub
		Query q = entityManager.createQuery("SELECT x FROM Movie x ");
		return q.getResultList();
	}

}
