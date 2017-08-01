package springMongo.MovieStore.service;


import java.util.List;

import springMongo.MovieStore.bean.Result;
import springMongo.MovieStore.bean.Users;


public interface UserService {

	public Users save(Users users);
	
	public Users getUser(String name);
	
	public List<Result> getAvgrating(Integer id);
}
