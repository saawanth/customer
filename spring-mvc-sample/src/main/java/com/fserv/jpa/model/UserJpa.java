package com.fserv.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fserv.model.User;

@Entity
@Table(name = "my_users")
public class UserJpa implements User {

  @Id
  private String username;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "email")
  private String email;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getCellPhoneNumber() {
    return cellPhoneNumber;
  }

  public void setCellPhoneNumber(Long cellPhoneNumber) {
    this.cellPhoneNumber = cellPhoneNumber;
  }

  @Column(name = "cell_phone_number")
  private Long cellPhoneNumber;

  @Override
  public String getName() {
    return firstName;
  }

  @Override
  public void setName(String name) {
    this.firstName = name;
  }

  @Override
  public Long getContactNumber() {
    return this.cellPhoneNumber;
  }

  @Override
  public void setContactNumber(Long contactNumber) {
    this.cellPhoneNumber = contactNumber;
  }


}
