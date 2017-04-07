package com.fserv.repo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fserv.model.User;


// @Component
public class UserJdbcRepo implements UserRepo {

  // @Autowired
  private JdbcTemplate jdbcTemplate;

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public User save(User user) {
    // jdbcTemplate.execute
    return null;
  }

  @Override
  public User find(Integer userId) {
    // jdbcTemplate.query
    return null;
  }

  @Override
  public List<User> findAll() {
    // jdbcTemplate.query
    return null;
  }

}
