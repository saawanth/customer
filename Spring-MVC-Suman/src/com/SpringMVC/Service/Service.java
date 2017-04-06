package com.SpringMVC.Service;

import java.util.HashMap;

import com.SpringMVC.Model.User;

public interface Service {
	HashMap<String,User> hmap=new HashMap<String,User>();
public void create(User user);
public void insert();
public User find(String username);
}
