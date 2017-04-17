package com.springmvc.dtohelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvc.dto.MovieDto;
import com.springmvc.dto.RatingDto;
import com.springmvc.dto.UserDto;
import com.springmvc.model.Rating;
import com.springmvc.model.User;

@Component
public class RatingDtoHelperImpl implements RatingDtoHelper {

	@Autowired
	private UserDtoHelper userDtoHelper;

	@Autowired
	private MovieDtoHelper movieDtoHelper;

	@Override
	public Rating dtoToModel(RatingDto dto) {
		Rating rating = new Rating();
		rating.setRate(dto.getRate());

		return rating;
	}

	@Override
	public RatingDto modelToDto(Rating model) {
		RatingDto ratingDto = new RatingDto();
		ratingDto.setRid(model.getRid());
		ratingDto.setRate(model.getRate());

		UserDto userDto = userDtoHelper.modelToDto(model.getUser());
		MovieDto movieDto = movieDtoHelper.modelToDto(model.getMovie());
		
	//	ratingDto.setUser(userDto);
		ratingDto.setUsername(userDto.getName());
		ratingDto.setAge(userDto.getAge());
		ratingDto.setMovie(movieDto);
		return ratingDto;
	}

}
