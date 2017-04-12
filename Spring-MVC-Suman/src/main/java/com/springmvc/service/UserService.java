package com.springmvc.service;

import java.util.HashMap;

import com.springmvc.model.User;

public interface UserService {
	HashMap<String,User> hmap=new HashMap<String,User>();
	void insert(User user);

	public String find(String username);
}
