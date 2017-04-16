package com.srujanonit.app.dto.helper;

import org.springframework.stereotype.Component;

import com.srujanonit.app.dao.model.Movie;
import com.srujanonit.app.dto.MovieDto;


@Component
public class MovieDtoHelper implements DtoHelper<MovieDto, Movie> {

	public Movie dtoToModel(MovieDto dto) {
		// TODO Auto-generated method stub
		Movie movie = null;
		if (dto != null) {
			movie = new Movie();
			movie.setMovieid(dto.getMovieid());
			movie.setTitle(dto.getTitle());
		}
		return movie;
	}

	public MovieDto modelToDto(Movie model) {
		// TODO Auto-generated method stub
		MovieDto movieDto = new MovieDto();
		movieDto.setMovieid(model.getMovieid());
		movieDto.setTitle(model.getTitle());
		movieDto.setGenre(model.getGenre());

		return movieDto;
	}

}
