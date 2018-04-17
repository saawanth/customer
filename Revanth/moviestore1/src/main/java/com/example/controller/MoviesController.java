package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MovieDetails;
import com.example.repo.MovieDetailsRepo;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	private MovieDetailsRepo movieDetailsRepo;

	@RequestMapping("/hi")
	public String hello() {
		return "helloWorld";
	}

	@GetMapping("/")
	public ResponseEntity<List<MovieDetails>> getMovies() {
		List<MovieDetails> movieDetails = movieDetailsRepo.findAll();
		return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDetails> getMovieById(@PathVariable("id") Integer id) {
		MovieDetails oneMovieDetails = movieDetailsRepo.getOne(id);
		return new ResponseEntity<MovieDetails>(oneMovieDetails, HttpStatus.OK);
	}

	@GetMapping("/getMoviesByGenre")
	public ResponseEntity<List<MovieDetails>> getMoviesByGenre(@RequestParam("genre") String genre) {
		List<MovieDetails> movieDetails = movieDetailsRepo.getMoviesByGenre(genre);
		return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
	}

	@GetMapping("/genreid/{genre}/{id}")
	public ResponseEntity<List<MovieDetails>> getMoviesByGenreAndId(@PathVariable("genre") String genre,
			@PathVariable("id") int id) {
		List<MovieDetails> movieDetails = movieDetailsRepo.getMoviesByGenreAndId(genre, id);
		if (movieDetails != null) {
			return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<MovieDetails>>(HttpStatus.NOT_FOUND);
		}
	}

}
