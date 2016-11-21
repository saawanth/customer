package com.sample.test.dto;

public class UserRatingDto {
  
  private double rating;
  private Long movieId;
  private Long userId;
  private MoviesDto movies;
  private UserDto users;
 
public UserDto getUsers() {
	return users;
}

public void setUsers(UserDto users) {
	this.users = users;
}

public double getRating() {
    return rating;
  }
 
  public void setRating(double rating) {
    this.rating = rating;
  }

public Long getMovieId() {
	return movieId;
}

public void setMovieId(Long movieId) {
	this.movieId = movieId;
}

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public MoviesDto getMovies() {
	return movies;
}

public void setMovies(MoviesDto movies) {
	this.movies = movies;
}
 
  
  
  

}
