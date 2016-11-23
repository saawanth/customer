package org.movie.store.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserMoviesDto {

	private UserDto user;
	private int numOfMoviesWatched;
	private List<UserRatingDto> userRatings;

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
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
