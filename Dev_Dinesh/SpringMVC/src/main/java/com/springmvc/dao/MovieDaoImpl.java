package com.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

	
	
	
	public List<Movie> getMovieByUser(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select r.username,m.title,r.rating from Movie m left join Rating r on m.mid=r.mid where r.username=:name");
		query.setParameter("name",username);
		List list=query.list();
		return list;

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
