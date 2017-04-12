package com.fserv.jpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fserv.jpa.model.UserJpa;
import com.fserv.model.User;
import com.fserv.repo.UserRepo;

@Repository
public class UserJpaRepo implements UserRepo {

  @PersistenceContext
  private EntityManager entityManager;

  public User save(User user) {
    entityManager.persist(user);
   
    return user;
  }

  @Override
  public User find(Integer userId) {
    UserJpa user = entityManager.find(UserJpa.class, userId);
    return user;
  }

  @Override
  public List<User> findAll() {
    Query q = entityManager.createQuery("SELECT x FROM UserJpa x ");
    return q.getResultList();
  }

}
