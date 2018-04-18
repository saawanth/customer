package com.ms.repo;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ms.model.UserDetails;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	@Transactional
	public List<UserDetails> getUsers() {	
		       
        Query theQuery = sessionFactory.getCurrentSession().createQuery("from user_details", UserDetails.class);        
        List<UserDetails> users = theQuery.getResultList();        
        System.out.println(users);		
		return users;
	}

}
