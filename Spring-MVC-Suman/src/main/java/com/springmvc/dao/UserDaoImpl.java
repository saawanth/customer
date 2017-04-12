package com.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.User;

@Transactional
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void insert(User user) {
		entityManager.persist(user);
		

	}

	@Override
	public String find(String username) {
		String user = username;
		//entityManager.find(User.class, username);
		

		return null;
	}

}
