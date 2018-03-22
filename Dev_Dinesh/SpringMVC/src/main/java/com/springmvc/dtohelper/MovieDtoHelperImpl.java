package com.springmvc.dtohelper;

import org.springframework.stereotype.Component;

import com.springmvc.dto.MovieDto;
import com.springmvc.model.Movie;

@Component
public class MovieDtoHelperImpl implements MovieDtoHelper {

	public Movie dtoToModel(MovieDto dto) {
		Movie movie=new Movie();
		movie.setMid(dto.getMid());
		movie.setTitle(dto.getTitle());
		movie.setGenre(dto.getGenre());
		return movie;
	}
	
	public MovieDto modelToDto(Movie model) {
		MovieDto movie = new MovieDto();
		movie.setTitle(model.getTitle());
		movie.setGenre(model.getGenre());
		movie.setMid(model.getMid());
		return movie;
	}

}
