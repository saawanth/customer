package com.springmvc.dtohelper;

import com.springmvc.dto.MovieDto;
import com.springmvc.model.Movie;

public class MovieDtoHelperImpl implements MovieDtoHelper<Movie,MovieDto>{

	@Override
	public Movie dtoToModel(MovieDto dto) {
		Movie movie=new Movie();
		movie.setMoviename(dto.getMoviename());
		movie.setGenre(dto.getGenre());
		return movie;
	}

	@Override
	public MovieDto modelToDto(Movie model) {
		
		return null;
	}

}
