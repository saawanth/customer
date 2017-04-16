package com.srujanonit.app.dao.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.srujanonit.app.dao.model.User;

@Repository
public class UserRepo implements BaseRepo<Long, User>{

	@PersistenceContext
	private EntityManager entityManager;
	
	public User save(User entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	public User find(long id) {
		// TODO Auto-generated method stub
		User user = entityManager.find(User.class, id);
		return user;
	}

	public User update(User entity) {
		// TODO Auto-generated method stub
		
		return entityManager.merge(entity);
	}

	public User delete(Long id) {
		// TODO Auto-generated method stub
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
		return user;
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		Query q = entityManager.createQuery("SELECT x FROM User x ");
		return q.getResultList();
	}

}
