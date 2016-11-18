package com.sample.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.test.dto.UserDto;
import com.sample.test.model.User;
import com.sample.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userrepo;
  
  @Override
  public UserDto getmovies(long id) {
   
   User user= userrepo.getSpecificUser(id);
   UserDto userdto = new UserDto();
   userdto.setId(user.getId());
   
   
    
    return userdto;
  }

}
