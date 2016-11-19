package com.sample.test.dto;

import java.util.List;

public class UserDto {
  
 
  private Long id;
  private String  movie;
  private double rating;
  private List<UserRatingDto> ratingsDto;

 


  /**
   * @return the ratingsDto
   */
  public List<UserRatingDto> getRatingsDto() {
    return ratingsDto;
  }

  /**
   * @param ratingsDto the ratingsDto to set
   */
  public void setRatingsDto(List<UserRatingDto> ratingsDto) {
    this.ratingsDto = ratingsDto;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
 
  public String getMovie() {
    return movie;
  }
 
  public void setMovie(String movie) {
    this.movie = movie;
  }
 
  public double getRating() {
    return rating;
  }
 
  public void setRating(double rating) {
    this.rating = rating;
  }
 

  

}
