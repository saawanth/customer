
package com.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.springmvc.dao.MovieDao;
import com.springmvc.dao.UserDao;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.model.User;
import com.springmvc.service.MovieService;
import com.springmvc.service.RatingService;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/")
public class ControllerHome {
	ArrayList<Rating> rates = null;
	@Autowired
UserService userService;
	@Autowired
	MovieService movieService;
	@Autowired
	RatingService ratingService;
	 

	@RequestMapping(value = "home", method = RequestMethod.POST)
	public String home(User user, ModelMap model) {
		userService.insert(user);
		model.put("name", user.getName());

		model.put("age", user.getAge());

		return "home";

	}

	@RequestMapping(value = "moviedetails", method = RequestMethod.POST)
	public String moviedetails(@ModelAttribute("movie") Movie movie, ModelMap model) {
		movieService.insert(movie);
		model.put("name", movie);

		return "moviedisplay";

	}

	@RequestMapping(value = "ratingfunc", method = RequestMethod.POST)
	public String ratingfunc(@RequestParam("mid") int mid,@RequestParam("rate") int rate,@RequestParam("username") String username, ModelMap model) {
		
		Rating rating=new Rating();
		User user2=userService.find(username);
		Movie movie2=movieService.find(mid);
		rating.setUser(user2);
		rating.setMovie(movie2);
		rating.setRate(rate);
		ratingService.insert(rating);
		model.put("rating", rating.getRate());
		model.put("username", username);
		model.put("mid", mid);
		

		
		

		return "rating";
	}
	
	
	/*@RequestMapping(value = "find", method = RequestMethod.POST)
	public String find(@RequestParam("username") String username, ModelMap model) {

		if (username.equals("") || username == null) {
			return "error";
		} else {
			List<Movie> movies = movieService.find(username);
			
			model.put("movie", movies);
		
		}
		return "display";
	}
	*/


}
