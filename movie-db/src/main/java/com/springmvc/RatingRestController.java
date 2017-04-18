package com.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dto.RatingDto;
import com.springmvc.dto.UserDto;
import com.springmvc.dtohelper.MovieDtoHelper;
import com.springmvc.dtohelper.RatingDtoHelper;
import com.springmvc.dtohelper.UserDtoHelper;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.model.User;
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
	
	@Autowired
	UserDtoHelper userDtoHelper;

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
	public List<RatingDto> find(@PathVariable("title") String moviename){
		
		Movie movie=movieService.find(moviename);
		List<Rating> ratings=ratingService.findRating(movie.getMid());
		List<RatingDto> ratingDto= new ArrayList<>();
		for(Rating rating:ratings){
			ratingDto.add(ratingDtoHelper.modelToDto(rating));
		}
		
		return ratingDto;
		
	}
	
	@RequestMapping(value="/ratings/insertrating",method=RequestMethod.POST)
	public ResponseEntity<RatingDto> insertrating(@RequestBody RatingDto ratingDto){
		
		Rating rating=ratingDtoHelper.dtoToModel(ratingDto);
		ratingService.insert(rating);
		
		return new ResponseEntity<>(ratingDto,HttpStatus.OK) ;
		
	}
	
	
	@RequestMapping(value="/ratings/updaterating/{rid}",method=RequestMethod.PUT)
	public ResponseEntity<RatingDto> updaterating(@PathVariable int rid, @RequestBody RatingDto ratingDto){
		Rating rating=ratingService.findRatingById(rid);
		rating.setRating(ratingDto.getRating());
		Movie movie=movieDtoHelper.dtoToModel(ratingDto.getMovie());
		rating.setMovie(movie);
		User user=userDtoHelper.dtoToModel(ratingDto.getUser());
		rating.setUser(user);

		ratingService.update(rating);
		
		return new ResponseEntity<>(ratingDto,HttpStatus.OK) ;
		
	}
	
	
	@RequestMapping(value = "/ratings/{rid}", method = RequestMethod.DELETE)
	public ResponseEntity<Rating> deleteUser(@PathVariable("rid") int rid) {

		Rating rating=ratingService.findRatingById(rid);
		ratingService.delete(rating);
		// UserDto usrDto1 = (UserDto) dtoHelper.modelToDto(user);
		return null;

		// return new ResponseEntity<>(usrDto1, HttpStatus.OK);

	}
	

}
