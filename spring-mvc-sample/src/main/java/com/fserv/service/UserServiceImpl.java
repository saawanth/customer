package com.fserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fserv.model.User;
import com.fserv.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  @Qualifier("userJpaRepo")
  private UserRepo userRepo;

  public User createUser(User user) {
    return userRepo.save(user);
  }

  public User find(Integer userId) {
    return userRepo.find(userId);
  }

  public List<User> findAll() {
    return userRepo.findAll();
  }

}
