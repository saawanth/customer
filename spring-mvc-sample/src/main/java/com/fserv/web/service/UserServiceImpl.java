package com.fserv.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.fserv.web.model.User;

@Component
public class UserServiceImpl implements UserService {

  private final AtomicInteger userIdCounter = new AtomicInteger(1);
  private ConcurrentHashMap<Integer, User> usersMap = new ConcurrentHashMap<>();

  public User createUser(User user) {
    user.setId(userIdCounter.getAndIncrement());
    usersMap.put(user.getId(), user);

    return user;
  }

  public User find(Integer userId) {
    return usersMap.get(userId);
  }

  public List<User> findAll() {
    return new ArrayList<>(usersMap.values());
  }

}
