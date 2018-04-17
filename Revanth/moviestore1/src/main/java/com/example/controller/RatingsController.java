package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Ratings;
import com.example.repo.RatingsRepo;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	@Autowired
	private RatingsRepo ratingsRepo;

	@GetMapping("/")
	public ResponseEntity<List<Ratings>> getAllRatings() {
		List<Ratings> ratings = (List<Ratings>) ratingsRepo.findAll();
		return new ResponseEntity<List<Ratings>>(ratings, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Ratings>> getRatingsById(@PathVariable("id") int id) {
		List<Ratings> ratings = (List<Ratings>) ratingsRepo.getMoviesById(id);
		return new ResponseEntity<List<Ratings>>(ratings, HttpStatus.OK);
	}

	@GetMapping("/avg/{id}")
	public ResponseEntity<List<Ratings>> getAvgRatingsById(@PathVariable("id") int id) {
		List<Ratings> avgRating = (List<Ratings>) ratingsRepo.getAvgRating(id);
		// double avgRating = 0;
		// int count = 0;
		// for (Ratings r : ratings) {
		// avgRating = avgRating + r.getMovie_rating();
		// count++;
		// }
		// avgRating = avgRating / count;
		return new ResponseEntity<List<Ratings>>(avgRating, HttpStatus.OK);
	}
}
