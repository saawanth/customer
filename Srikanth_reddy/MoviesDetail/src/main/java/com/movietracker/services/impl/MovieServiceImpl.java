package com.movietracker.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.movietracker.domain.UserDetails;
import com.movietracker.repository.MoviesDetailRepo;
import com.movietracker.repository.UsersDetailRepo;
import com.movietracker.domain.MovieDetails;
import com.movietracker.services.MovieService;

@Component("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private UsersDetailRepo usersDetailRepo;
	@Autowired
	private MoviesDetailRepo moviesDetailRepo;
	Log logger = LogFactory.getLog(MovieServiceImpl.class);

	public UserDetails validateUser(String username) {
		// TODO Auto-generated method stub
		return usersDetailRepo.findByUsername(username);
	}

	public void addUser(String username, int age) {
		// TODO Auto-generated method stub
		UserDetails userDetails = new UserDetails();
		userDetails.setAge(age);
		userDetails.setUsername(username);
		usersDetailRepo.save(userDetails);

	}

	public MovieDetails validateMovie(String title) {
		// TODO Auto-generated method stub
		return moviesDetailRepo.findByTitle(title);
	}

	public void addMovie(String title, String genre, float rating, long addedBy) {
		// TODO Auto-generated method stub
		MovieDetails movieDetails = new MovieDetails();
		movieDetails.setGenre(genre);
		movieDetails.setRating(rating);
		movieDetails.setTitle(title);
		movieDetails.setAddedBy(addedBy);
		moviesDetailRepo.save(movieDetails);

	}

//	public List<MovieDetails> gettitleReport(String title) {
//		// TODO Auto-generated method stub
//		
////		UserDetails userDetails = new UserDetails();
////		usersDetailRepo.save(userDetails);
//
//		return moviesDetailRepo.MovieByTitle(title);
//	}

	public List<MovieDetails> getAllReport() {
		// TODO Auto-generated method stub
		return (List<MovieDetails>) moviesDetailRepo.findAll();
	}

	public List<MovieDetails> getTitleReport(String title) {
		// TODO Auto-generated method stub
		return moviesDetailRepo.MovieByTitle(title);
	}

	public List<UserDetails> userReport() {
		// TODO Auto-generated method stub
		return (List<UserDetails>) usersDetailRepo.findAll();
	}

	public List<MovieDetails> getMovieByUser(long userId) {
		// TODO Auto-generated method stub
		return moviesDetailRepo.moviesByUser(userId);
	}

	public List<MovieDetails> getMovieByGenre(String genre) {
		// TODO Auto-generated method stub
		return moviesDetailRepo.moviesByGenre(genre);
	}

}
