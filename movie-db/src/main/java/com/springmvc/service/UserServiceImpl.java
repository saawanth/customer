package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDao;
import com.springmvc.dto.UserDto;
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
	public User find(String username) {
	return userDao.find(username);
		
	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
	}

	@Override
	public void update(User user) {
		
		userDao.update(user);
	}

/*	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}*/

	@Override
	public void patch(User currentUser,UserDto userDto) {
	
		if(userDto.getAge()!=0){
			currentUser.setAge(userDto.getAge());
		}
		userDao.update(currentUser);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

}
