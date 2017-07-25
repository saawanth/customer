package springMongo.MovieStore.Controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.AggregateIterable;

import springMongo.MovieStore.bean.Users;
import springMongo.MovieStore.dao.AppDao;
import springMongo.MovieStore.error.CustomError;
import springMongo.MovieStore.repository.UserRepository;
import springMongo.MovieStore.service.UserService;

@RestController
public class AppController {

	@Autowired
	AppDao appdao;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	public ResponseEntity<?> getUserDetails(@RequestBody String user)
	{
		List<Document> doc =  appdao.getUser(user);
		return new ResponseEntity<List<Document>>(doc, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getRating", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMovieRating(@RequestBody int movieId)
	{
		Document document =  appdao.getAvgRating(movieId);
		return new ResponseEntity<Document>(document, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody String userName)
	{
		Users users = userService.save(userName);
		if(users == null)
		{
			return new ResponseEntity<CustomError>(new CustomError("cannot create a user collection"), HttpStatus.CONFLICT);
		}
		else
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
}
