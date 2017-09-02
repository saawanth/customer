package com.fserv.repo;

import java.util.List;

import com.fserv.model.User;

public interface UserRepo {

	public User save(User user);

	public User find(String userName);

	public List<User> findAll();
}
