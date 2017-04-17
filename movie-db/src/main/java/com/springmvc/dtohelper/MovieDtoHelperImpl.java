package com.springmvc.dtohelper;

import org.springframework.stereotype.Component;

import com.springmvc.dto.MovieDto;
import com.springmvc.model.Movie;

@Component
public class MovieDtoHelperImpl implements MovieDtoHelper {

	@Override
	public Movie dtoToModel(MovieDto dto) {
		Movie movie = new Movie();
		movie.setMid(dto.getMid());
		movie.setMoviename(dto.getMoviename());
		movie.setGenre(dto.getGenre());
		return movie;
	}

	@Override
	public MovieDto modelToDto(Movie model) {
		MovieDto movie = new MovieDto();
		movie.setMoviename(model.getMoviename());
		movie.setGenre(model.getGenre());
		movie.setMid(model.getMid());
		return movie;
	}

}
