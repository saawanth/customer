package springMongo.MovieStore.bean;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Users {

	@Id
	public String id;
	
	public String userName;
	
	public int age;
	
	public List<MoviesWatched> moviesWatched;
	
	public Users( String userName, int age, List<MoviesWatched> moviesWatched)
	{
		this.userName = userName;
		this.age = age;
		this.moviesWatched = moviesWatched;
	}
	
}
