package com.ms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.UserDetails;
import com.ms.repo.UserDAOImpl;

@RestController
public class MovieStoreController {
	
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	@GetMapping("/list")
	public ResponseEntity<List<UserDetails>> getUserDetails(){
		List<UserDetails> user = userDAOImpl.getUsers();
		return new ResponseEntity<List<UserDetails>>(user, HttpStatus.OK);	
	}
	

}
