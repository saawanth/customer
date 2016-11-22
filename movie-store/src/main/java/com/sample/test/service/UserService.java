package com.sample.test.service;

import com.sample.test.dto.UserDto;
import com.sample.test.dto.UserMoviesDto;

public interface UserService extends BaseService<Long, UserDto> {

	public UserMoviesDto getMoviesWatchedByUser(long userId);

}
