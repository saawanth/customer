package org.movie.store.service;

import org.movie.store.dto.UserDto;
import org.movie.store.dto.UserMoviesDto;

public interface UserService extends BaseService<Long, UserDto> {

	public UserMoviesDto getMoviesWatchedByUser(long userId);

}
