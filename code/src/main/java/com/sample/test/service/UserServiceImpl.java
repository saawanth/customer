package com.sample.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.test.dto.UserDto;
import com.sample.test.dto.UserRatingDto;
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
   List<UserRatingDto> userRatingdto = new ArrayList<>();
   for(UserRating urating:userrating){
  
     UserRatingDto userratingdto = new UserRatingDto();
     userratingdto.setRating(urating.getRating());
     userRatingdto.add(userratingdto);
    
   }
   userdto.setRatingsDto(userRatingdto);
   return userdto;
}
}