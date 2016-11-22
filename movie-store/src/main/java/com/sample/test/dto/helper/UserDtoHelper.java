package com.sample.test.dto.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sample.test.dto.UserDto;
import com.sample.test.model.User;

@Component
public class UserDtoHelper implements DtoHelper<User, UserDto> {

	@Override
	public List<UserDto> buildDto(Iterable<User> models) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto buildDto(User model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User build(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> build(Iterable<UserDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
