package com.sample.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.test.dto.UserDto;
import com.sample.test.service.UserService;

@RestController
@RequestMapping("/myservice")
public class UserController {
  
  @Autowired
  private UserService userservice;
  
  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces ="application/json", consumes = "application/json")
  public @ResponseBody ResponseEntity<UserDto>  getMoviesById(@PathVariable (value="id") long id) {
       UserDto userDto = userservice.getmovies(id) ;
       if(userDto==null)
         return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
       return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);    
       
  }

}
