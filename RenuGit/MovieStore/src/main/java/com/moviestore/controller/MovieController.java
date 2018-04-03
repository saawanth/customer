package com.moviestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.moviestore.dao.MovieDAO;
import com.moviestore.dao.RatingDAO;
import com.moviestore.exception.AbstractControllerExceptionHandler;
import com.moviestore.model.MovieDetails;
import com.moviestore.model.Rating;

@RestController
public class MovieController extends AbstractControllerExceptionHandler{
	@Autowired
	private MovieDAO movieDAO;
	@Autowired
	private RatingDAO ratingDAO;

	@GetMapping("/movies")
	public ResponseEntity<List<MovieDetails>> getName() {
		List<MovieDetails> movieDetails = (List<MovieDetails>) movieDAO.findAll();
		return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
	}

	@GetMapping(value = "movie/{uID}")
	public ResponseEntity<List<Rating>> getMovies(@PathVariable("uID") int uID) {
		List<Rating> ratings = ratingDAO.getMoviesById(uID);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}

	@GetMapping(value = "ratings/{mID}")
	public ResponseEntity<List<Rating>> getRatings(@PathVariable("mID") int mID) {
		List<Rating> ratings = ratingDAO.getRatingById(mID);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}

	@GetMapping(value = "movies/{genre}")
	public ResponseEntity<List<MovieDetails>> getMoviesWithRatingsById(@PathVariable("genre") String genre) {
		List<MovieDetails> movieDetails = movieDAO.getMoviesWithRatingsByGenre(genre);
		return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
	}

	@GetMapping(value = "movies/genre/{genre}/{id}")
	public ResponseEntity<List<MovieDetails>> getMoviesWithRatingsByGenreAndId(@PathVariable("genre") String genre,
			@PathVariable("id") int id) {
		List<MovieDetails> movieDetails = movieDAO.getMoviesWithRatingsByGenreAndId(genre, id);
		return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
	}
	
	@GetMapping(value = "movies/testException")
	public ResponseEntity<String> testException() {
		throw new NullPointerException("Testing empty exception");
//		return new ResponseEntity<String>("xyz", HttpStatus.OK);
	}

}
