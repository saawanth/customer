package com.springmvc.dtohelper;

import org.springframework.stereotype.Component;

import com.springmvc.dto.MovieDto;
import com.springmvc.model.Movie;
@Component
public interface MovieDtoHelper extends DtoHelper<Movie, MovieDto> {

}
