package com.springmvc.dtohelper;

import com.springmvc.dto.MovieDto;
import com.springmvc.model.Movie;

public interface MovieDtoHelper {

	public Movie dtoToModel(MovieDto dto);

	public MovieDto modelToDto(Movie model);
}
