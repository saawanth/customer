package com.srujanonit.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srujanonit.app.dao.model.Movie;
import com.srujanonit.app.dto.MovieDto;
import com.srujanonit.app.dto.helper.MovieDtoHelper;
import com.srujanonit.app.service.MovieServiceImpl;

@RestController
public class MovieRestController {

	@Autowired
	MovieServiceImpl movieServiceImpl;

	@Autowired
	MovieDtoHelper dtoHelper;

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<MovieDto> getAllMovies() {
		List<MovieDto> list = new ArrayList<MovieDto>();
		for (Movie movie : movieServiceImpl.findAll()) {
			list.add(dtoHelper.modelToDto(movie));
		}
		return list;
	}

	@RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
	public MovieDto findMovie(@PathVariable("movieId") Long movieId) {

		return dtoHelper.modelToDto(movieServiceImpl.find(movieId));
	}

	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public MovieDto saveMovie(@RequestBody MovieDto movie) {
		return dtoHelper.modelToDto(movieServiceImpl.save(dtoHelper.dtoToModel(movie)));
	}

	@RequestMapping(value = "/movies/{movieId}", method = RequestMethod.PUT)
	public MovieDto updateMovie(@PathVariable("movieId") Long movieId, @RequestBody MovieDto movieDto) {
		Movie movie = movieServiceImpl.find(movieId);
		movie.setMovieid(movieDto.getMovieid());
		movie.setTitle(movieDto.getTitle());
		movie.setGenre(movieDto.getGenre());
		return dtoHelper.modelToDto(movie);
	}

	@RequestMapping(value = "/movies/{movieId}", method = RequestMethod.DELETE)
	public MovieDto deleteMovie(@PathVariable("movieId") Long movieId) {
		Movie movie = movieServiceImpl.delete(movieId);
		return dtoHelper.modelToDto(movie);
	}

}
