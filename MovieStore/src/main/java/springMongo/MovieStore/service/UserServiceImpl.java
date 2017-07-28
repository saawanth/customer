package springMongo.MovieStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import springMongo.MovieStore.bean.Movieswatched;
import springMongo.MovieStore.bean.Result;
import springMongo.MovieStore.bean.Users;
import springMongo.MovieStore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	public Users save(Users users)
	{				
		Users user = userRepository.save(users);
		return user;
	}
	
	public Users getUser(String name)
	{
		Users user = userRepository.findByuserName(name);
		return user;
	}

	@Override
	public List<Result> getAvgrating(Integer id) {
		List<Result> users = userRepository.findByAvgRating(id);
		return users;
	}
	
	
}
