package com.fserv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.fserv.model.User;

@Service
public class InMemoryUserServiceImpl implements UserService {

  private ConcurrentHashMap<String, User> usersMap = new ConcurrentHashMap<>();

  public User createUser(User user) {
    usersMap.put(user.getUsername(), user);

    return user;
  }

  public User find(Integer userId) {
    return usersMap.get(userId);
  }

  public List<User> findAll() {
    return new ArrayList<>(usersMap.values());
  }

}
