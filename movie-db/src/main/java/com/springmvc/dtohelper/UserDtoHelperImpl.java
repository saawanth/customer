package com.springmvc.dtohelper;

import org.springframework.stereotype.Component;

import com.springmvc.dto.UserDto;
import com.springmvc.model.User;

@Component
public class UserDtoHelperImpl implements UserDtoHelper {

	@Override
	public User dtoToModel(UserDto dto) {
		User user = new User();
		user.setUsername(dto.getName());
		user.setAge(dto.getAge());
		return user;
	}

	@Override
	public UserDto modelToDto(User model) {
		UserDto userDto = new UserDto();
		userDto.setName(model.getUsername());
		userDto.setAge(model.getAge());

		return userDto;
	}

}
