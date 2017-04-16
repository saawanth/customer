package com.srujanonit.app.dto.helper;

import org.springframework.stereotype.Component;

import com.srujanonit.app.dao.model.Movie;
import com.srujanonit.app.dao.model.User;
import com.srujanonit.app.dto.UserDto;

@Component
public class UserDtoHelper implements DtoHelper<UserDto, User> {

	public User dtoToModel(UserDto dto) {
		// TODO Auto-generated method stub
		User user = null;
		if (dto != null) {
			user = new User();
			user.setUserid(dto.getUserid());
			user.setFirstname(dto.getFirstname());
			user.setLastname(dto.getLastname());
			user.setAge(dto.getAge());
		}
		return user;
	}

	public UserDto modelToDto(User model) {
		// TODO Auto-generated method stub
		UserDto userDto = new UserDto();
		userDto.setUserid(model.getUserid());
		userDto.setFirstname(model.getFirstname());
		userDto.setLastname(model.getLastname());
		userDto.setAge(model.getAge());

		return userDto;
	}

}
