package com.srujanonit.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srujanonit.app.dao.model.User;
import com.srujanonit.app.dao.repo.UserRepo;


@Service
@Transactional
public class UserServiceImpl implements BaseService<Long, User>{

	
	@Autowired
	UserRepo userRepo;
	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.getAll();
	}

	public User find(Long id) {
		// TODO Auto-generated method stub
		return userRepo.find(id);
	}

	public User save(User entity) {
		// TODO Auto-generated method stub
		return userRepo.save(entity);
	}

	public User update(User entity) {
		// TODO Auto-generated method stub
		return userRepo.update(entity);
	}

	public User delete(Long id) {
		// TODO Auto-generated method stub
		return userRepo.delete(id);
	}


}
