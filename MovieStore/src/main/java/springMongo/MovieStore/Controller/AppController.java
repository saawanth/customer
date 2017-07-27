package springMongo.MovieStore.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.client.AggregateIterable;

import springMongo.MovieStore.bean.Movieswatched;
import springMongo.MovieStore.bean.Result;
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
	
	@RequestMapping(value="/getUser/{name}", method=RequestMethod.GET)
	public ResponseEntity<?> getUserDetails(@PathVariable String name)
	{
		Users userres =  userService.getUser(name);
		
		if(userres == null)
		{
			return new ResponseEntity<CustomError>(new CustomError("cannot find user with name"+name), HttpStatus.CONFLICT);
		}
		else
			return new ResponseEntity<Users>(userres, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getRating/{name}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMovieRating(@PathVariable String name)
	{
         List<Result> users = userService.getAvgrating(name);     
         if(users == null)
 		{
 			return new ResponseEntity<CustomError>(new CustomError("cannot find any users"), HttpStatus.CONFLICT);
 		}
 		else
		return  new ResponseEntity<List<Result>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody Users users)
	{
		Users userres = userService.save(users);
		if(userres == null)
		{
			return new ResponseEntity<CustomError>(new CustomError("cannot create a user collection"), HttpStatus.CONFLICT);
		}
		else
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Users> get() {
		List<Movieswatched> list =  new ArrayList<Movieswatched>();
		Movieswatched mw = new Movieswatched("super man", 4.5);
		Movieswatched mw1 = new Movieswatched("homealone", 4.0);
		list.add(mw);
		list.add(mw1);
	    Users user = new Users("uday", 30, list);

	    return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
}
