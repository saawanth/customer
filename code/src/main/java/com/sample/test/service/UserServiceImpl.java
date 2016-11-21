package com.sample.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.test.dto.MoviesDto;
import com.sample.test.dto.UserDto;
import com.sample.test.dto.UserRatingDto;
import com.sample.test.model.Movies;
import com.sample.test.model.UserRating;
import com.sample.test.model.Users;
import com.sample.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userrepo;
  
  @Override
  public UserDto getmovies(long id) {
   
	  Users user= userrepo.getSpecificUser(id);
	  List<UserRating> userrating = user.getUserRatings();
	  UserDto userdto = new UserDto();
	  userdto.setId(user.getId());
	  List<UserRatingDto> userRatingdtoList = new ArrayList<UserRatingDto>();
	  
	  for(UserRating urating:userrating){
	 
	    UserRatingDto userratingdto = new UserRatingDto();
	    userratingdto.setRating(urating.getRating());
	    Movies movies = urating.getMovies() ;
	    MoviesDto moviesdto= new MoviesDto();
	    
	    moviesdto.setMovieName(movies.getMovieName());
	    userratingdto.setMovies(moviesdto);
	       userRatingdtoList.add(userratingdto);
	     }
	  userdto.setRatingsDto(userRatingdtoList);
	  return userdto;
	}

@Override
public MoviesDto getMoviesAvgById(long id) {
	Movies movies = userrepo.getMoviesAvgById(id);
	MoviesDto moviesDto=new MoviesDto();
	moviesDto.setId(movies.getId());
	double totalRating=0;
	long size=0;
	
	List<UserRating> userRating = movies.getUserRatings();
	List<UserRatingDto> userRatingDtoList = new ArrayList<UserRatingDto>();
	for(UserRating uRating:userRating){
		UserRatingDto userRatingDto2=new UserRatingDto();
		userRatingDto2.setRating(uRating.getRating());
		totalRating=totalRating+uRating.getRating();
		size=size+1;
		userRatingDtoList.add(userRatingDto2);
				
	}
	double aveRating=totalRating/size;
	moviesDto.setAverageMovieRating(aveRating);
	moviesDto.setUserRatings(userRatingDtoList);
		return moviesDto;
}

@Override
public MoviesDto getTopMovies(long id, String movieGenre) {
	
	return null;
}
}