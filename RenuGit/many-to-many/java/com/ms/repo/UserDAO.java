package com.ms.repo;

import java.util.List;

import com.ms.model.UserDetails;

public interface UserDAO {

	public List<UserDetails> getUsers();
}
