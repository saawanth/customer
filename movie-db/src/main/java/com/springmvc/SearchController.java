package com.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dtohelper.MovieDtoHelper;
import com.springmvc.dtohelper.RatingDtoHelper;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.service.MovieService;
import com.springmvc.service.RatingService;
import com.springmvc.service.UserService;



@RestController
public class SearchController {

		@Autowired
		UserService userService;
		
		@Autowired
		MovieService movieService;
		
		
		@Autowired
		RatingService ratingService;

		@Autowired
		MovieDtoHelper movieDtoHelper;

		@Autowired
		RatingDtoHelper ratingDtoHelper;


@RequestMapping(value="search/{genre}/{username}",method=RequestMethod.GET)
public List<Rating> findMovies(@PathVariable("genre") String genre, @PathVariable("username") String username){
	
	List<Movie> movies= movieService.findMovieByGenre(genre);


	List<Rating> ratings=ratingService.findUserRatingByGenre(genre, username);
	return ratings;
	
	
}
	
	
}
