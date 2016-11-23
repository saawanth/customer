package com.sample.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.test.dto.MovieDto;
import com.sample.test.model.Genre;
import com.sample.test.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController extends BaseControllerImpl<Long, MovieDto> {

	@Autowired
	public MovieController(MovieService baseService) {
		super(baseService);
	}

	@RequestMapping(value = "/avgRating/{movieId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<MovieDto> findMovieWithAvgRating(
			@PathVariable(value = "movieId") long movieId) {
		MovieDto movieDto = ((MovieService) resourceService).findMovieWithAvgRating(movieId);
		if (movieDto == null) {
			return new ResponseEntity<MovieDto>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<MovieDto>(movieDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/top5ByGenre/{genre}/{userId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<List<MovieDto>> getTopMovies(@PathVariable(value = "userId") long userId,
			@PathVariable(value = "genre") Genre genre) {
		List<MovieDto> top5movies = ((MovieService) resourceService).findTop5MoviesByGenre(userId, genre);
		if (top5movies == null) {
			return new ResponseEntity<List<MovieDto>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<MovieDto>>(top5movies, HttpStatus.OK);
	}
}
