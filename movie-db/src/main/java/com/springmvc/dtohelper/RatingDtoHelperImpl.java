package com.springmvc.dtohelper;

import com.springmvc.dto.RatingDto;
import com.springmvc.model.Rating;
import com.springmvc.model.User;
import com.springmvc.service.MovieService;
import com.springmvc.service.UserService;

public class RatingDtoHelperImpl implements RatingDtoHelper<Rating,RatingDto> {


	@Override
	public Rating dtoToModel(RatingDto dto) {
		Rating rating=new Rating();
		rating.setRate(dto.getRate());
		
		return rating;
	}

	@Override
	public RatingDto modelToDto(Rating model) {
		
		return null;
	}

}
