package com.fserv.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {


  @RequestMapping(method = RequestMethod.GET)
  public String home() {
    return "myindex.html";
  }


  @RequestMapping(value = "health", method = RequestMethod.GET)
  public String health() {
    return "health";
  }
}
