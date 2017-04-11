package com.fserv.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "my_user_address")
public class UserAddress {

  @Id
  @SequenceGenerator(name = "MY_USER_ADDRESS_ID_GENERATOR", sequenceName = "my_user_address_id_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_USER_ADDRESS_ID_GENERATOR")
  private Long id;

  @ManyToOne()
  @JoinColumn(name = "addr_username")
  private UserJpa user;

  @Column(name = "address1")
  private String address1;

  @Column(name = "address2")
  private String address2;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "zip")
  private Integer zip;

  @Column(name = "country")
  private String county;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserJpa getUser() {
    return user;
  }

  public void setUser(UserJpa user) {
    this.user = user;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getZip() {
    return zip;
  }

  public void setZip(Integer zip) {
    this.zip = zip;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

}
