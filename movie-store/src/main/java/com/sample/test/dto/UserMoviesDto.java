package com.sample.test.dto;

import java.util.List;

public class UserMoviesDto {

	private UserDto userDto;
	private int numOfMoviesWatched;
	private List<UserRatingDto> userRatings;

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public List<UserRatingDto> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<UserRatingDto> userRatings) {
		this.userRatings = userRatings;
	}

	public int getNumOfMoviesWatched() {
		return numOfMoviesWatched;
	}

	public void setNumOfMoviesWatched(int numOfMoviesWatched) {
		this.numOfMoviesWatched = numOfMoviesWatched;
	}

}
