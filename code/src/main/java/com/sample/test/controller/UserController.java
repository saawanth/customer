package com.sample.test.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  
  @RequestMapping(value = "/users/{id}", method = RequestMethod.POST, produces ="application/json", consumes = "application/json")
  public @ResponseBody void  registerUser(@PathVariable (value="id") long id) {
       return ;
       
  }

}
