package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.repo.UserDetailsRepo;

@RestController
public class UserDetailsController {
	
	@Autowired
	private UserDetailsRepo userDetailsRepo;
	
	

}
