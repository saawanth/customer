package org.movie.store.dto.helper;

import java.util.List;

import org.movie.store.dto.UserDto;
import org.movie.store.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoHelper implements DtoHelper<User, UserDto> {

	@Override
	public List<UserDto> buildDto(Iterable<User> models) {
		return null;
	}

	@Override
	public UserDto buildDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setFirstname(user.getFirstname());
		userDto.setLastname(user.getLastname());
		userDto.setUserId(user.getId());
		userDto.setDateOfBirth(user.getDateOfBirth());
		return userDto;
	}

	@Override
	public User build(UserDto dto) {
		User user = new User();
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setId(dto.getUserId());
		user.setDateOfBirth(dto.getDateOfBirth());
		return user;
	}

	@Override
	public List<User> build(Iterable<UserDto> dtos) {
		return null;
	}

}
