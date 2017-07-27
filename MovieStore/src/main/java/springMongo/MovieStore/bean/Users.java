package springMongo.MovieStore.bean;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="users")
public class Users {

	@Id
	public String id;
	
	public String userName;
	
	public int Age;
	
	public List<Movieswatched> movieswatched;
	
	public Users( String userName, int age, List<Movieswatched> Movieswatched)
	{
		this.userName = userName;
		this.Age = age;
		this.movieswatched = Movieswatched;
	}
	public Users() {}
}
