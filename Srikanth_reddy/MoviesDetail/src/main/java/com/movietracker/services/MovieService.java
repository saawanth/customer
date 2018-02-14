package com.movietracker.services;

import java.util.List;

import com.movietracker.domain.UserDetails;
import com.movietracker.domain.MovieDetails;

public interface MovieService {
	UserDetails validateUser(String username);
	void addUser(String username, int age);
	
	MovieDetails validateMovie(String title);
	void addMovie(String title, String genre, float rating, long addedBy);
	
	List<MovieDetails> getTitleReport(String title);

	List<MovieDetails> getAllReport();

	List<MovieDetails> getMovieByUser(long userId);

	List<MovieDetails> getMovieByGenre(String genre);

}
