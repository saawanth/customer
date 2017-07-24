package SpringMongo.MovieStore.Controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringMongo.MovieStore.dao.AppDao;

@RestController
public class AppController {

	@Autowired
	AppDao appdao;
	
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	public ResponseEntity<?> getUserDetails(@RequestBody String user)
	{
		List<Document> doc =  appdao.getUser(user);
		return new ResponseEntity<List<Document>>(doc, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getRating", method=RequestMethod.POST)
	public ResponseEntity<?> getMovieRating(@RequestBody int movieId)
	{
		Document doc =  appdao.getAvgRating(movieId);
		return new ResponseEntity<Document>(doc, HttpStatus.OK);
	}
}
