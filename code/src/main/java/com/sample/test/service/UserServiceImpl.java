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
   List<UserRatingDto> userRatingdto = new ArrayList<UserRatingDto>();
   for(UserRating urating:userrating){
  
     UserRatingDto userratingdto = new UserRatingDto();
     userratingdto.setRating(urating.getRating());
     userRatingdto.add(userratingdto);
    
   }
   userdto.setRatingsDto(userRatingdto);
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
	List<UserRatingDto> userRatingDto = new ArrayList<UserRatingDto>();
	for(UserRating uRating:userRating){
		UserRatingDto userRatingDto2=new UserRatingDto();
		userRatingDto2.setRating(uRating.getRating());
		totalRating=totalRating+uRating.getRating();
		size=size+1;
		userRatingDto.add(userRatingDto2);
				
	}
	double aveRating=totalRating/size;
	moviesDto.setAverageMovieRating(aveRating);
	moviesDto.setUserRatings(userRatingDto);
		return moviesDto;
}
}