package com.fserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fserv.model.User;
import com.fserv.repo.UserRepo;

// ------transaction - 1 started -------
// -complete unit of work in transaciton
// -------transaction - 1 ended ---------

// ------transaction - 2 started -------
// complete unit of work in transaciton
// ------transaction - 1 ended ---------

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  // @Qualifier("inMemUserRepo")
  private UserRepo userRepo;

  public UserServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public UserRepo getUserRepo() {
    return userRepo;
  }

  public void setUserRepo(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public User createUser(User user) {
    return userRepo.save(user);
  }

  public User find(String userId) {
    return userRepo.find(userId);
  }

  public List<User> findAll() {
    return userRepo.findAll();
  }

}
