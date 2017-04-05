package com.fserv.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fserv.model.User;

@Component
public class UserJdbcRepo implements UserRepo {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public User save(User user) {
//  jdbcTemplate.execute
    return null;
  }

  @Override
  public User find(Integer userId) {
//    jdbcTemplate.query
    return null;
  }

  @Override
  public List<User> findAll() {
//  jdbcTemplate.query
    return null;
  }

}
