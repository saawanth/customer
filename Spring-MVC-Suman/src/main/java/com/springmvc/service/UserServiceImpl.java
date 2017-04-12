package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	

	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public String find(String username) {
	return userDao.find(username);
		
	}

}
