package com.fserv.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fserv.model.User;

@Entity
@Table(name = "my_users")
public class UserJpa implements User {

  @Id
  @Column(name = "username")
  private String username;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  List<UserAddress> userAddresses;

  public List<UserAddress> getUserAddresses() {
    return userAddresses;
  }

  public void setUserAddresses(List<UserAddress> userAddresses) {
    this.userAddresses = userAddresses;
  }

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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
