package com.fserv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.fserv.jpa.model.UserAddress;
import com.fserv.jpa.model.UserJpa;
import com.fserv.model.User;
import com.fserv.service.UserService;

@Controller
public class UserController {

  @Autowired
  @Qualifier("userServiceImpl")
  UserService userService;

  @RequestMapping(value = "/userHome", method = RequestMethod.GET)
  public ModelAndView home() {
    Map<String, UserJpa> model = new HashMap<>();
    model.put("user", new UserJpa());
    ModelAndView modelView = new ModelAndView("createUser", model);
    return modelView;
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute("user") final UserJpa userJpa,
      final BindingResult result, final ModelMap model) {
    // adding two sample userAddress.
    List<UserAddress> userAddresses = new ArrayList<>();
    userAddresses.add(buildUserAddress(userJpa));
    userAddresses.add(buildUserAddress(userJpa));
    userJpa.setUserAddresses(userAddresses);
    
    User savedUser = userService.createUser(userJpa);

    Map<String, User> userModel = new HashMap<>();
    userModel.put("user", savedUser);

    ModelAndView modelView = new ModelAndView("viewUser", userModel);

    return modelView;
  }

  public UserAddress buildUserAddress(UserJpa userJpa) {
    UserAddress usrAdd = new UserAddress();
    usrAdd.setUser(userJpa);
    usrAdd.setAddress1("28345 Beck Rd");
    usrAdd.setAddress1("Suite 109");
    usrAdd.setCity("Wixom");
    usrAdd.setState("MI");;
    usrAdd.setZip(48322);
    usrAdd.setCounty("U.S.A");
    return usrAdd;
  }

}
