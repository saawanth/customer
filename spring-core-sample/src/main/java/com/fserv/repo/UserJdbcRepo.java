package com.fserv.repo;
//Demo
import java.util.List;

import com.fserv.model.User;
import com.fserv.repo.UserRepo;

public class UserJdbcRepo implements UserRepo {

	// // @Autowired
	// private JdbcTemplate jdbcTemplate;
	//
	// public JdbcTemplate getJdbcTemplate() {
	// return jdbcTemplate;
	// }
	//
	// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	// this.jdbcTemplate = jdbcTemplate;
	// }

	public User save(User user) {
		// jdbcTemplate.execute
		return null;
	}

	@Override
	public User find(String userName) {
		// jdbcTemplate.query
		return null;
	}

	@Override
	public List<User> findAll() {
		// jdbcTemplate.query
		return null;
	}

}
