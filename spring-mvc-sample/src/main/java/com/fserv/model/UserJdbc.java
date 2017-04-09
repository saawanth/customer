package com.fserv.model;

public class UserJdbc implements User {

  private String username;
  private String name;
  private Long contactNumber;

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

  public Long getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(Long contactNumber) {
    this.contactNumber = contactNumber;
  }

}
