package com.sample.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.test.dto.MoviesDto;
import com.sample.test.dto.UserDto;
import com.sample.test.service.UserService;

@RestController
@RequestMapping("/myservice")
public class UserController {
  
  @Autowired
  private UserService userservice;
  
  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody ResponseEntity<UserDto>  getMoviesById( @PathVariable (value="id") long id) {
       UserDto userDto = userservice.getmovies(id) ;
       if(userDto==null)
         return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
       return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);    
       
  }
  @RequestMapping(value = "/moviesavg/{id}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody ResponseEntity<MoviesDto>  getMoviesAvgById( @PathVariable (value="id") long id) {
	  MoviesDto moviesDto = userservice.getMoviesAvgById(id) ;
       if(moviesDto==null)
         return new ResponseEntity<MoviesDto>(HttpStatus.BAD_REQUEST);
       return new ResponseEntity<MoviesDto>(moviesDto,HttpStatus.OK);    
       
  }  
  @RequestMapping(value = "/topmovies/{userid}/{genre}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody ResponseEntity<MoviesDto>  getTopMovies( @PathVariable (value="id") long id, @PathVariable (value="movieGenre") String movieGenre ) {
	  MoviesDto moviesDto = userservice.getTopMovies(id, movieGenre);
       if(moviesDto==null)
         return new ResponseEntity<MoviesDto>(HttpStatus.BAD_REQUEST);
       return new ResponseEntity<MoviesDto>(moviesDto,HttpStatus.OK);    
       
  }  

}
