package com.sample.test.dto;

public class UserDto {
  
 
  private Long id;
  private String  movie;
  private double rating;
  private Long count;
  
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
 
  public long getCount() {
    return count;
  }
 
  public void setCount(long count) {
    this.count = count;
  }
  
  

}
