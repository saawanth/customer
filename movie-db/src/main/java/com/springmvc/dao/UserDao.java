package com.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.model.User;
@Repository
public interface UserDao {

	void insert(User user);

	public User find(String username);

	List<User> findAll();

	void update(User user);

	void delete(User user);
}
