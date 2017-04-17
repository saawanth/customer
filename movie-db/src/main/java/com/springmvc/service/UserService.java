package com.springmvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springmvc.dto.UserDto;
import com.springmvc.model.User;


public interface UserService {
	HashMap<String,User> hmap=new HashMap<String,User>();
	void insert(User user);

	public User find(String username);
	public List<User> findAll();

	void update(User user);

	void delete(User user);

	void patch(User currentUser, UserDto userDto);
}
