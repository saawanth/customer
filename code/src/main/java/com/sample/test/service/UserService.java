package com.sample.test.service;

import com.sample.test.dto.MoviesDto;
import com.sample.test.dto.UserDto;

public interface UserService {
  
  public UserDto getmovies(long id);
  public MoviesDto getMoviesAvgById(long id);

}
