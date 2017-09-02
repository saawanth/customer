package com.fserv.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.fserv.model.User;

@Service
public class InMemoryUserRepo implements UserRepo {

	private ConcurrentHashMap<String, User> usersMap = new ConcurrentHashMap<>();

	public User createUser(User user) {
		usersMap.put(user.getUsername(), user);

		return user;
	}

	public User find(String userName) {
		return usersMap.get(userName);
	}

	public List<User> findAll() {
		return new ArrayList<>(usersMap.values());
	}

	@Override
	public User save(User user) {
		return usersMap.put(user.getUsername(), user);
	}

}
