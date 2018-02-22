package com.springmvc.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.springmvc.model.Movie;

public class MovieDaoImpl extends HibernateDaoSupport implements MovieDao {

	public Movie find(String moviename) {
		return null;
	}

	public List<Movie> findMovieByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	public Movie find(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> findAll() {
		return getHibernateTemplate().loadAll(Movie.class);
	}

}
