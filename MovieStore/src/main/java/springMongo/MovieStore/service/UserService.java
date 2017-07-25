package springMongo.MovieStore.service;

import org.springframework.stereotype.Service;

import springMongo.MovieStore.bean.Users;


public interface UserService {

	public Users save(String name);
}
