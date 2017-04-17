package com.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dto.RatingDto;
import com.springmvc.dtohelper.MovieDtoHelper;
import com.springmvc.dtohelper.RatingDtoHelper;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.service.MovieService;
import com.springmvc.service.RatingService;
import com.springmvc.service.UserService;

@RestController
public class RatingRestController {
	ArrayList<Rating> rates = null;
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

	@RequestMapping(value = "/ratings", method = RequestMethod.GET)
	public List<RatingDto> findAll() {

		List<Rating> ratings = ratingService.findAll();
		List<RatingDto> ratingDtos = new ArrayList<>();
		for (Rating rating : ratings) {
			ratingDtos.add((RatingDto) ratingDtoHelper.modelToDto(rating));
		}
		return ratingDtos;

	}
	
	@RequestMapping(value = "/ratings/{title}", method = RequestMethod.GET)
	public RatingDto find(@PathVariable("title") String moviename){
		
		Movie movie=movieService.find(moviename);
		Rating rating=ratingService.findRating(movie.getMid());
		
		return ratingDtoHelper.modelToDto(rating);
		
	}
}
