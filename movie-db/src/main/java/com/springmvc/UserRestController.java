
package com.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dto.MovieDto;
import com.springmvc.dto.RatingDto;
import com.springmvc.dto.UserDto;
import com.springmvc.dtohelper.DtoHelper;
import com.springmvc.dtohelper.MovieDtoHelper;
import com.springmvc.dtohelper.RatingDtoHelper;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.model.User;
import com.springmvc.service.MovieService;
import com.springmvc.service.RatingService;
import com.springmvc.service.UserService;

@RestController
public class UserRestController {
	ArrayList<Rating> rates = null;
	@Autowired
	UserService userService;
	@Autowired
	MovieService movieService;
	@Autowired
	RatingService ratingService;
	@Autowired
	DtoHelper dtoHelper;
	@Autowired
	MovieDtoHelper movieDtoHelper;
	@Autowired
	RatingDtoHelper ratingDtoHelper;

	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public List<UserDto> findAll() {

		List<User> users = userService.findAll();
		List<UserDto> userDtos = new ArrayList();
		for (User user : users) {
			userDtos.add((UserDto) dtoHelper.modelToDto(user));
		}
		return userDtos;

	}

	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
	public UserDto findUser(@PathVariable("username") String userName) {

		User user = userService.find(userName);
		
		UserDto userDto = (UserDto) dtoHelper.modelToDto(user);

		return userDto;

	}

	@RequestMapping(value = "/users/{username}", method = RequestMethod.PUT)
	public ResponseEntity<UserDto> createUser(@PathVariable("username") String userName, @RequestBody UserDto userDto) {

		User currentUser = userService.find(userName);

		currentUser.setAge(userDto.getAge());
		userService.update(currentUser);

		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.PATCH)
	public ResponseEntity<UserDto> incrementUpdate(@PathVariable("username") String userName, @RequestBody UserDto userDto) {

		User currentUser = userService.find(userName);

		
		userService.insert(currentUser);

		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto) {

		User user = (User) dtoHelper.dtoToModel(userDto);
		userService.insert(user);
		UserDto usrDto1 = (UserDto) dtoHelper.modelToDto(user);

		return new ResponseEntity<>(usrDto1, HttpStatus.OK);

	}
}
