package com.fserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fserv.model.User;
import com.fserv.repo.UserRepo;

@Service
public class UserJdbcServiceImpl implements UserService {

  @Autowired
  private UserRepo userRepo;

  public User createUser(User user) {
    // user.setId(userIdCounter.getAndIncrement());
    // usersMap.put(user.getId(), user);
    return userRepo.save(user);
  }

  public User find(Integer userId) {
    return userRepo.find(userId);
  }

  public List<User> findAll() {
    return userRepo.findAll();
  }

}
