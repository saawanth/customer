package com.fserv.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fserv.dto.helper.UserDtoHelper;
import com.fserv.jpa.model.UserJpa;
import com.fserv.model.User;
import com.fserv.service.UserService;

/**
 * REST API users, GET --- This APU will get all users from the backend. users, POST with a
 * requestbody --- This API will create a new user.
 *
 */

@RestController
@RequestMapping(value = "/users")
public class UserRestController {

  @Autowired
  @Qualifier("userServiceImpl")
  UserService userService;

  @Autowired
  UserDtoHelper usrtDtoHelper;

  @RequestMapping(method = RequestMethod.GET)
  public List<UsrDto> findAll() {
    List<User> users = userService.findAll();
    List<UsrDto> usrDtos = new ArrayList<>();
    for (User user : users) {
      usrDtos.add(usrtDtoHelper.modelToDto((UserJpa) user));
    }
    return usrDtos;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<UsrDto> save(@RequestBody final UsrDto userDto) {
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

    return new ResponseEntity<>(savedUsrDto, HttpStatus.OK);
  }
  
  @RequestMapping(method = RequestMethod.PATCH)
  public ResponseEntity<UsrDto> updateUsrDto(@RequestBody final UsrDto userDto) {
    // transform dtos to model
    UserJpa userJpa = usrtDtoHelper.dtoToModel(userDto);

    // call the save to store in DB.
    User savedUser = userService.createUser(userJpa);

    // transform model back to dto for UI clients.
    UsrDto savedUsrDto = usrtDtoHelper.modelToDto((UserJpa) savedUser);

    return new ResponseEntity<>(savedUsrDto, HttpStatus.OK);
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
