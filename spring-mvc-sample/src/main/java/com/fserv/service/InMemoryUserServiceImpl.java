package com.fserv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.fserv.model.User;

@Service
public class InMemoryUserServiceImpl implements UserService {

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
