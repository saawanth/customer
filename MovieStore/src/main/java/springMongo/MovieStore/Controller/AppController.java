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

import springMongo.MovieStore.dao.AppDao;
import springMongo.MovieStore.repository.UserRepository;

@RestController
public class AppController {

	@Autowired
	AppDao appdao;
	
	@Autowired
	UserRepository userRepository;
	
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
	
	
}
