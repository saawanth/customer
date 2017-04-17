package com.springmvc.dtohelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvc.dto.MovieDto;
import com.springmvc.dto.RatingDto;
import com.springmvc.dto.UserDto;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.model.User;
import com.springmvc.service.MovieService;
import com.springmvc.service.UserService;

@Component
public class RatingDtoHelperImpl implements RatingDtoHelper {

	@Autowired
	private UserDtoHelper userDtoHelper;

	@Autowired
	private MovieDtoHelper movieDtoHelper;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;
	


	@Override
	public Rating dtoToModel(RatingDto dto) {
		
		Rating rating = new Rating();
		rating.setRate(dto.getRating());
		Movie movie=movieService.find(dto.getMid());
		rating.setMovie(movie);
		User user=userService.find(dto.getUsername());
		
		rating.setUser(user);
		return rating;
		
	}

	@Override
	public RatingDto modelToDto(Rating model) {
		RatingDto ratingDto = new RatingDto();
		ratingDto.setRid(model.getRid());
		ratingDto.setRate(model.getRate());
		User user=model.getUser();
		ratingDto.setUsername(user.getUsername());
		Movie movie=model.getMovie();
		ratingDto.setMid(movie.getMid());
		
	
		return ratingDto;
	}

}
