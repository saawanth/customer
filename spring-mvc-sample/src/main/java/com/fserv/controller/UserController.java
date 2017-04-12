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

import com.fserv.dto.UsrAddressDto;
import com.fserv.dto.UsrDto;
import com.fserv.dto.helper.UserDtoHelper;
import com.fserv.jpa.model.UserJpa;
import com.fserv.model.User;
import com.fserv.service.UserService;

@Controller
public class UserController {

  @Autowired
  @Qualifier("userServiceImpl")
  UserService userService;

  @Autowired
  UserDtoHelper usrtDtoHelper;

  @RequestMapping(value = "/userHome", method = RequestMethod.GET)
  public ModelAndView home() {
    Map<String, UsrDto> model = new HashMap<>();
    model.put("user", new UsrDto());
    ModelAndView modelView = new ModelAndView("createUser", model);
    return modelView;
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute("user") final UsrDto userDto,
      final BindingResult result, final ModelMap model) {
    // adding two sample userAddress.
    List<UsrAddressDto> userAddresses = new ArrayList<>();
    userAddresses.add(buildUserAddress(userDto));
    userAddresses.add(buildUserAddress(userDto));

    userDto.setUsrAddresses(userAddresses);

    // transform dtos to model
    UserJpa userJpa = usrtDtoHelper.dtoToModel(userDto);

    // call the save to store in DB.
    User savedUser = userService.createUser(userJpa);

    // transform model back to dto for UI clients.
    UsrDto savedUsrDto = usrtDtoHelper.modelToDto((UserJpa) savedUser);

    Map<String, UsrDto> userDtoModel = new HashMap<>();
    userDtoModel.put("user", savedUsrDto);

    ModelAndView modelView = new ModelAndView("viewUser", userDtoModel);

    return modelView;
  }

  public UsrAddressDto buildUserAddress(UsrDto userDto) {
    UsrAddressDto usrAdd = new UsrAddressDto();
    usrAdd.setAddress1("28345 Beck Rd");
    usrAdd.setAddress1("Suite 109");
    usrAdd.setCity("Wixom");
    usrAdd.setState("MI");;
    usrAdd.setZip(48322);
    usrAdd.setCounty("U.S.A");
    return usrAdd;
  }

}
