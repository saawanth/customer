package com.sample.test.service;

import java.util.List;

import com.sample.test.dto.MovieDto;
import com.sample.test.model.Genre;

public interface MovieService extends BaseService<Long, MovieDto> {

	public MovieDto findMovieWithAvgRating(long id);

	public List<MovieDto> findTop5MoviesByGenre(long userId, Genre genre);
}
