package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.model.User;
@Repository
public interface UserDao {

	void insert(User user);

	public User find(String username);
}
