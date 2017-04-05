package com.fserv.service;

import java.util.List;

import com.fserv.model.User;

public interface UserService {

  public User createUser(User user);

  public User find(Integer id);

  public List<User> findAll();

}
