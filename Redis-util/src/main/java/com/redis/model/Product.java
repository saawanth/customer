package com.redis.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Product implements Serializable {

	  private String name;
	  private double price;
	  private String desc;
	  private int quantity;


	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public double getPrice() {
	    return price;
	  }

	  public void setPrice(double price) {
	    this.price = price;
	  }

	  public String getDesc() {
	    return desc;
	  }

	  public void setDesc(String desc) {
	    this.desc = desc;
	  }

	  public int getQuantity() {
	    return quantity;
	  }

	  public void setQuantity(int quantity) {
	    this.quantity = quantity;
	  }

	}