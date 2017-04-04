package com.fserv.web.service;

import java.util.List;

import com.fserv.web.model.User;

public interface UserService {

  public User createUser(User user);

  public User find(Integer id);

  public List<User> findAll();

}
