package com.SpringMVC.ServiceImpl;

import com.SpringMVC.Model.User;
import com.SpringMVC.Service.Service;

public class UserService implements Service {

	@Override
	public void create(User user) {
		hmap.put(user.getName(), user);

	}

	@Override
	public void insert() {

	}

	@Override
	public User find(String username) {
		User user = hmap.get(username);
		return user;
	}

}
