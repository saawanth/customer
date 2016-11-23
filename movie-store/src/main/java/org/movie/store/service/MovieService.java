package org.movie.store.service;

import java.util.List;

import org.movie.store.dto.MovieDto;
import org.movie.store.model.Genre;

public interface MovieService extends BaseService<Long, MovieDto> {

	public MovieDto findMovieWithAvgRating(long id);

	public List<MovieDto> findTop5MoviesByGenre(long userId, Genre genre);
}
