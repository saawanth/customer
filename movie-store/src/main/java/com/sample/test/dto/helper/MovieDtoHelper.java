package com.sample.test.dto.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sample.test.dto.MovieDto;
import com.sample.test.model.Movie;

@Component
public class MovieDtoHelper implements DtoHelper<Movie, MovieDto> {

	public MovieDto buildDto(Movie movie) {
		MovieDto movieDto = null;
		if (movie != null) {
			movieDto = new MovieDto();
			movieDto.setName(movie.getName());
			movieDto.setGenre(movie.getGenre());
			movieDto.setAvgRating(movie.getRating());
		}
		return movieDto;
	}

	public Movie build(MovieDto movieDto) {
		Movie movie = null;
		if (movieDto != null) {
			movie = new Movie();
			movie.setName(movieDto.getName());
			movie.setGenre(movieDto.getGenre());
			movie.setId(movieDto.getId());
		}
		return movie;
	}

	@Override
	public List<MovieDto> buildDto(Iterable<Movie> models) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		if (models != null) {
			for (Movie movie : models) {
				movieDtos.add(buildDto(movie));
			}
		}
		return movieDtos;
	}

	@Override
	public List<Movie> build(Iterable<MovieDto> dtos) {
		return null;
	}
}
