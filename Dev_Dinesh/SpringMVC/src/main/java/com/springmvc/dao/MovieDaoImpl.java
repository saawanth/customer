package com.springmvc.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.springmvc.model.Movie;

public class MovieDaoImpl extends HibernateDaoSupport implements MovieDao {

	public Movie find(String moviename) {
		
		return (Movie) getHibernateTemplate().load(Movie.class, moviename);
	}

	public List<Movie> findMovieByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	public Movie find(int mid) {
		 return (Movie) getHibernateTemplate().load(Movie.class, mid);
	}

	/*public List<Movie> findAll() {
		return getHibernateTemplate().loadAll(Movie.class);
	}*/
	
	public List<Movie> findAll() {
		return  getHibernateTemplate().loadAll(Movie.class);
	}
	
	

}
