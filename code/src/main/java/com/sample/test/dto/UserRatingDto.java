package com.sample.test.dto;

public class UserRatingDto {
  
  private double rating;
  private Long movie_id;
  private Long user_id;
 
  public double getRating() {
    return rating;
  }
 
  public void setRating(double rating) {
    this.rating = rating;
  }
 
  public Long getMovie_id() {
    return movie_id;
  }
  
  public void setMovie_id(Long movie_id) {
    this.movie_id = movie_id;
  }
  
  public Long getUser_id() {
    return user_id;
  }
  
  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }
  
  

}
