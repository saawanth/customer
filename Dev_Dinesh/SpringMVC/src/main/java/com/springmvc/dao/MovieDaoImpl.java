package com.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Movie;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	public Movie find(String moviename) {
		return (Movie) sessionFactory.getCurrentSession().get(Movie.class, moviename);
	}

	public List<Movie> findMovieByGenre(String genre) {
		return null;
	}

	public Movie find(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Movie").list();
	}

	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Movie> getMovieByUser(String username) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Movie where Movie.ratings.username=:name");
		query.setParameter("name", username);
		return query.list();
		//return sessionFactory.getCurrentSession().createNativeQuery("from Movie where Movie.users.username=:username",username).list();
	}

	public Movie getMovieByMovieId(int id) {
		return (Movie) sessionFactory.getCurrentSession().get(Movie.class, id);
	}

	public void addMovie(Movie movie) {
		sessionFactory.getCurrentSession().save(movie);
		
	}

	public void deleteMovie(int id) {
		Movie movie=sessionFactory.getCurrentSession().load(Movie.class, id);
		if(null!=movie) {
			this.sessionFactory.getCurrentSession().delete(movie);
		}
		
	}

	public void updateMovie(Movie currentMovie) {
		sessionFactory.getCurrentSession().update(currentMovie);
		
	}
	
	

}
