package com.springmvc.service;

import java.util.HashMap;
import java.util.List;

import com.springmvc.model.User;

public interface UserService {
	HashMap<String,User> hmap=new HashMap<String,User>();
	void insert(User user);

	public User find(String username);
	public List<User> findAll();

	void update(User user);

	void delete(User user);
}
