package com.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Movie;
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
	public User find(String username) {
		String user = username;
	User user1=entityManager.find(User.class, username);
		

		return user1;
	}

	@Override
	public List<User> findAll() {
		 Query q = entityManager.createQuery("SELECT x FROM User x ");
		    return q.getResultList();
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(User user) {
		entityManager.remove(entityManager.merge(user));
		
	}

	@Override
	public void patch(User currentUser) {
		
		entityManager.merge(currentUser);
	}
		
	

}
