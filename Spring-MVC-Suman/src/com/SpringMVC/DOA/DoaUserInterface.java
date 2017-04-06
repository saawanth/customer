package com.SpringMVC.DOA;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringMVC.Model.Movies;
import com.SpringMVC.Model.User;
@Repository
public interface DoaUserInterface {

	void insert(User user);

	public String find(String username);
}
