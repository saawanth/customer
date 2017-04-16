package com.srujanonit.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srujanonit.app.dao.model.Movie;
import com.srujanonit.app.dao.model.User;
import com.srujanonit.app.dto.MovieDto;
import com.srujanonit.app.dto.UserDto;
import com.srujanonit.app.dto.helper.UserDtoHelper;
import com.srujanonit.app.service.UserServiceImpl;

@RestController
public class UserRestController {

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	UserDtoHelper userDtoHelper;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDto> getAllMovies() {
		List<UserDto> list = new ArrayList<UserDto>();
		for (User user : userService.findAll()) {
			list.add(userDtoHelper.modelToDto(user));
		}
		return list;
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public UserDto findUser(@PathVariable("userId") Long userId) {

		return userDtoHelper.modelToDto(userService.find(userId));
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public UserDto saveMovie(@RequestBody UserDto user) {
		return userDtoHelper.modelToDto(userService.save(userDtoHelper.dtoToModel(user)));
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	public UserDto updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
		User user = userService.find(userId);
		user.setUserid(userDto.getUserid());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setAge(userDto.getAge());
		return userDtoHelper.modelToDto(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public UserDto deleteUser(@PathVariable("userId") Long userId) {
		User user = userService.delete(userId);
		return userDtoHelper.modelToDto(user);
	}

	
}
