
package com.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dao.MovieDao;
import com.springmvc.dao.UserDao;
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
public class ControllerHome {
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
	
	
	

	

	@RequestMapping(value="/users",method = RequestMethod.GET)
	public List<UserDto> findAll() {
		
		
		List<User> users=userService.findAll();
		List<UserDto> userDtos=new ArrayList();
		for(User user:users){
			userDtos.add((UserDto) dtoHelper.modelToDto(user));
		}
		return userDtos;
		

	}
	
	@RequestMapping(value="/users/{username}" ,method = RequestMethod.GET)
	public UserDto findUser(@PathVariable("username") String userName) {
		
		
		User user=userService.find(userName);
		userService.delete(user);
		UserDto userDto=(UserDto) dtoHelper.modelToDto(user);
	
		return userDto;
		

	}
	
	
	@RequestMapping(value="updateUser/{username}", method = RequestMethod.PUT)
	public ResponseEntity<UserDto> createUser(@PathVariable("username") String userName, @RequestBody final UserDto userDto) {
		
		
		User user=userService.find(userName);
		user.setAge(userDto.getAge());
		
		userService.update(user);
		return new ResponseEntity<>(userDto,HttpStatus.OK);

	}



	@RequestMapping(value="createUser", method = RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto) {
		
		User user=(User) dtoHelper.dtoToModel(userDto);
	userService.insert(user);
UserDto usrDto1	= (UserDto) dtoHelper.modelToDto(user);
		
		return new ResponseEntity<>(usrDto1,HttpStatus.OK);

	}

	
	
	 

	@RequestMapping(value = "home", method = RequestMethod.POST)
	public String home(@ModelAttribute("user") UserDto userDto, ModelMap model) {
		
		User user=(User) dtoHelper.dtoToModel(userDto);
	userService.insert(user);
		model.put("name", user.getName());

		model.put("age", user.getAge());

		return "home";

	}

	@RequestMapping(value = "moviedetails", method = RequestMethod.POST)
	public String moviedetails(@ModelAttribute("movie") MovieDto movieDto, ModelMap model) {
		Movie movie=(Movie) movieDtoHelper.dtoToModel(movieDto);
		movieService.insert(movie);
		model.put("name", movie);

		return "moviedisplay";

	}

	@RequestMapping(value = "ratingfunc", method = RequestMethod.POST)
	public String ratingfunc(@ModelAttribute("rating") RatingDto ratingDto, ModelMap model) {
		
		Rating rating=(Rating) ratingDtoHelper.dtoToModel(ratingDto);
		User user=userService.find(ratingDto.getUsername());
		rating.setUser(user);
		Movie movie=movieService.find(ratingDto.getMid());
		rating.setMovie(movie);
		
		ratingService.insert(rating);
		
		model.put("rating", rating.getRate());
		model.put("username", ratingDto.getUsername());
		model.put("mid",ratingDto.getMid());
		

		
		

		return "rating";
	}
	
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String find(@RequestParam("moviename") String moviename, ModelMap model) {

		if (moviename.equals("") ||moviename == null) {
			return "error";
		} else {
			List<Movie> movies = movieService.find(moviename);
			
			model.put("movies", movies);
		
		}
		return "displaySearch";
	}
	


}
