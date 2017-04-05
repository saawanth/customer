package com.fserv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fserv.model.User;
import com.fserv.service.UserService;

@Controller
public class UserController {

  @Autowired
  @Qualifier("userJdbcServiceImpl")
  UserService userService;

  @RequestMapping(value = "/userHome", method = RequestMethod.GET)
  public ModelAndView home() {
    Map<String, User> model = new HashMap<>();
    model.put("user", new User());
    ModelAndView modelView = new ModelAndView("createUser", model);
    return modelView;
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute("user") final User user, final BindingResult result,
      final ModelMap model) {
    User savedUser = userService.createUser(user);

    Map<String, User> userModel = new HashMap<>();
    userModel.put("user", savedUser);

    ModelAndView modelView = new ModelAndView("viewUser", userModel);

    return modelView;
  }

}
