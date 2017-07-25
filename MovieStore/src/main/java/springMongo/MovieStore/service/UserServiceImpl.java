package springMongo.MovieStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMongo.MovieStore.bean.MoviesWatched;
import springMongo.MovieStore.bean.Users;
import springMongo.MovieStore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	List<MoviesWatched> list = null;
	
	public Users save(String name)
	{
		list = new ArrayList<MoviesWatched>();
		MoviesWatched mw = new MoviesWatched("super man", 3.5);
		MoviesWatched mw1 = new MoviesWatched("homealone", 3.0);
		list.add(mw);
		list.add(mw1);
		Users user = new Users(name, 28, list);
		Users users = userRepository.save(user);
		return users;
	}
}
