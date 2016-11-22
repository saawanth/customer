package com.sample.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.test.dto.UserMoviesDto;
import com.sample.test.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getMoviesWatched/{userId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<UserMoviesDto> getMoviesWatchedByUser(
			@PathVariable(value = "userId") long userId) {
		UserMoviesDto usrMoviesDto = userService.getMoviesWatchedByUser(userId);
		if (usrMoviesDto == null) {
			return new ResponseEntity<UserMoviesDto>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UserMoviesDto>(usrMoviesDto, HttpStatus.OK);

	}
}
