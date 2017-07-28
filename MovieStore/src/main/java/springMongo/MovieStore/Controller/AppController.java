package springMongo.MovieStore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import springMongo.MovieStore.bean.Movieswatched;
import springMongo.MovieStore.bean.Result;
import springMongo.MovieStore.bean.Users;
import springMongo.MovieStore.error.CustomError;
import springMongo.MovieStore.service.UserService;

@RestController
public class AppController {
	
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
	
	@RequestMapping(value="/getRating/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getMovieRating(@PathVariable Integer id)
	{
         List<Result> users = userService.getAvgrating(id);     
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
		//Movieswatched mw = new Movieswatched(1, "action", "spider man", 4.5);
		Movieswatched mw1 = new Movieswatched(3, "action", "bat man", 4.0);
		Movieswatched mw2 = new Movieswatched(2, "comedy", "homealone", 4.0);
		Movieswatched mw3 = new Movieswatched(4, "horror", "conjuring", 5.0);
		//list.add(mw);
		list.add(mw1);
		list.add(mw2);
		list.add(mw3);
	    Users user = new Users("sharan", 29, list);

	    return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
}
