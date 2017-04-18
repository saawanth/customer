package com.springmvc.dtohelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvc.dto.RatingDto;
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
		rating.setRating(dto.getRating());
		Movie movie = movieDtoHelper.dtoToModel(dto.getMovie());
		rating.setMovie(movie);
		User user = userDtoHelper.dtoToModel(dto.getUser());

		rating.setUser(user);
		return rating;

	}

	@Override
	public RatingDto modelToDto(Rating model) {
		RatingDto ratingDto = new RatingDto();
		ratingDto.setRid(model.getRid());
		ratingDto.setRating(model.getRating());

		User user = model.getUser();
		if (user != null) {
			ratingDto.setUser(userDtoHelper.modelToDto(user));
		}

		Movie movie = model.getMovie();
		if (movie != null) {
			ratingDto.setMovie(movieDtoHelper.modelToDto(movie));
		}

		return ratingDto;
	}

}
