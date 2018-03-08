package com.movietracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.movietracker.domain.UserDetails;

public interface UsersDetailRepo extends CrudRepository<UserDetails, String>{
	UserDetails findByUsername(String username);
//	query
	

}
