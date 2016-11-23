package org.movie.store.dto.helper;

import java.util.ArrayList;
import java.util.List;

import org.movie.store.dto.MovieDto;
import org.movie.store.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoHelper implements DtoHelper<Movie, MovieDto> {

	public MovieDto buildDto(Movie movie) {
		MovieDto movieDto = null;
		if (movie != null) {
			movieDto = new MovieDto();
			movieDto.setId(movie.getId());
			movieDto.setName(movie.getName());
			movieDto.setGenre(movie.getGenre());
			movieDto.setAvgRating(movie.getAvgRating());
		}
		return movieDto;
	}

	public Movie build(MovieDto movieDto) {
		Movie movie = null;
		if (movieDto != null) {
			movie = new Movie();
			movie.setId(movieDto.getId());
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
