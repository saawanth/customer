package com.sample.test.service;

import com.sample.test.dto.MoviesDto;
import com.sample.test.dto.UserDto;
import com.sample.test.dto.UserRatingDto;

public interface UserService {
  
  public UserDto getmovies(long id);
  public MoviesDto getMoviesAvgById(long id);
  public UserRatingDto getTopMovies(long userId, String movieGenre);

}
