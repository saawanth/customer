package com.springmvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.springmvc.model.Movie;
import com.springmvc.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieService movieService;
	
//Get all the movies in database
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> movieDetails = (List<Movie>) movieService.getAll();
		if(movieDetails.isEmpty()) {
			return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Movie>>(movieDetails,HttpStatus.OK);
	}

//Get  single movie name based on ID
	@RequestMapping(value="/movies/{mid}", method=RequestMethod.GET)
	public @ResponseBody Movie getMovieID(@PathVariable("mid") int mid){
		Movie movie=movieService.findById(mid);
		if(movie==null) {
			throw new RuntimeException();
		}
		return movie;
	}
	
//Get movie based on title
	/*@RequestMapping(value="/movies/{title}", method=RequestMethod.GET)
	public @ResponseBody Movie getMovieTitle(@PathVariable("title") String title){
		Movie movie=movieService.find(title);
		return movie;
	}*/

//Create a new movie
	@RequestMapping(value="/movies/", method=RequestMethod.POST)
	public ResponseEntity<?> createMovie(@RequestBody Movie movie, UriComponentsBuilder ucBuilder){
		movieService.saveMovie(movie);
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(ucBuilder.path("SpringMVC/movies/{id}").buildAndExpand(movie.getMid()).toUri());
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}

//Update a movie
	@RequestMapping(value = "/movies/{mid}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMovie(@PathVariable("mid") int mid, @RequestBody Movie movie) {
 
        Movie currentMovie = movieService.findById(mid);
 
        currentMovie.setMid(movie.getMid());
        currentMovie.setTitle(movie.getTitle());
        currentMovie.setGenre(movie.getGenre());
 
        movieService.updateMovie(currentMovie);
        return new ResponseEntity<Movie>(currentMovie,HttpStatus.OK);
	}
	
//Delete a movie
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<Movie>(HttpStatus.NO_CONTENT);
    }

	
	
	
	
	
	@RequestMapping(value = "/enterUsername", method = RequestMethod.GET)
	public ModelAndView getMovietByUser() {

		ModelAndView model = new ModelAndView();

		model.setViewName("ResultList/enterUsername");

		return model;
	}

	@RequestMapping(value="/moviesByUsername")
	public ModelAndView movieByUserID(@RequestParam(value="userId",required=false) String userId) {
		System.out.println("keyword"+ userId);
		ModelAndView model=new ModelAndView();
		List<Movie> movieDetails=movieService.getMovieByUser(userId);
		model.addObject("movieDetails",movieDetails);
		model.setViewName("ResultList/moviesByUsername");
		return model;
	}
	
/*	@RequestMapping(value = "/moviesByUser", method = RequestMethod.GET)
	public ModelAndView getMovieByUser(@RequestParam(value = "userId", required = false) long userId) {
		System.out.println("keyword  "+userId);
		ModelAndView model = new ModelAndView();
		List<Movie> movieDetails = movieService.getMovieByUser(username);
	
		
		model.addObject("movieDetails", movieDetails);
		
	int mov=movieDetails.size();
	System.out.println("size "+mov);
	model.addObject("mov", mov);
		model.setViewName("report/moviesReportByUser");

		return model;

	}*/
	/*@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		ModelAndView model = new ModelAndView();
		List<Movie> movieDetails = (List<Movie>) movieService.getAll();
		model.addObject("movieDetails", movieDetails);
		model.setViewName("movies/displaymovies");
		return movieDetails;
	}*/
	

}