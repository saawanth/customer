package com.fserv.dto;

import java.util.List;

public class UsrDto {

  private String username;

  private String name;

  private String contactNumber;

  private List<UsrAddressDto> usrAddresses;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public List<UsrAddressDto> getUsrAddresses() {
    return usrAddresses;
  }

  public void setUsrAddresses(List<UsrAddressDto> usrAddresses) {
    this.usrAddresses = usrAddresses;
  }


}
