package com.movietracker.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.movietracker.domain.MovieDetails;
import com.movietracker.domain.UserDetails;
import com.movietracker.services.MovieService;

@Controller
@RequestMapping("/")
public class MoviesController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView model=new ModelAndView();
		model.setViewName("home/home");
		return model;
		
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public ModelAndView addUser(){
		ModelAndView model=new ModelAndView();
		model.setViewName("movies/addUser");
		return model;
		
	}
	
	@RequestMapping(value="/addUserDetails", method=RequestMethod.POST)
	public ModelAndView addUser(
			@RequestParam(value="username", required=false)String username,
			@RequestParam(value="age",required=false)int age){
		
		ModelAndView model=new ModelAndView();
		UserDetails userDetails=movieService.validateUser(username);
		
		if(userDetails==null){
			movieService.addUser(username, age);
			model.addObject("Success", "User Added");
			model.setViewName("movies/addUser");
	}
		else{
			model.addObject("error", "User Already Exist!");
			model.setViewName("movies/addUser");
			
		}
		return model;
		

}
	
	
	@RequestMapping(value="/addMovieDetails", method=RequestMethod.POST)
	public ModelAndView addMovieDetails(
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value = "genre", required = false) String genre,
			@RequestParam(value = "rating", required = false) float rating,
			@RequestParam(value = "addedBy", required = false) long addedBy) {
		ModelAndView model=new ModelAndView();
		
		MovieDetails movieDetails=movieService.validateMovie(title);
		
		if(movieDetails==null){
			movieService.addMovie(title, genre, rating, addedBy);
			model.addObject("Success", "User Added");
			model.setViewName("movies/addMovies");
		}
		else{
			model.addObject("error","user already exist");
			model.setViewName("movies/addMovies");
		}
		return model;
	}
	
	

	
	
	
	
	@RequestMapping(value="/addMovie", method=RequestMethod.GET)
	public ModelAndView addMovie(){
		ModelAndView model=new ModelAndView();
		model.setViewName("movies/addMovies");
		return model;
		
	}
	@RequestMapping(value="/title", method=RequestMethod.GET)
	public ModelAndView keyword(){
		ModelAndView model=new ModelAndView();
		model.setViewName("report/SearchByTitle");
		return model;
		
	}

	@RequestMapping(value = "/searchByTitle", method = RequestMethod.GET)
	public ModelAndView searchByTitle(@RequestParam(value = "title", required = false) String title) {
		System.out.println("keyword  "+title);
		ModelAndView model = new ModelAndView();
		float average=0;
		float rating=0;
		List<MovieDetails> movieDetails = movieService.getTitleReport(title);
		int count=movieDetails.size();

		for(int i=0; i<movieDetails.size(); i++){
		
		 rating=rating+movieDetails.get(i).getRating();
	 
	
	}
	average =rating/count;
	
	 DecimalFormat dformat = new DecimalFormat();
	 dformat.setMaximumFractionDigits(2);
	 String averages= dformat.format(average);
		model.addObject("averages", averages);


		model.addObject("moviesDetails", movieDetails);
	
		
		
		model.setViewName("report/moviesReportByTitle");

		return model;

	}
	
	@RequestMapping(value = "/moviesReport", method = RequestMethod.GET)
	public ModelAndView searchByTitle() {

		ModelAndView model = new ModelAndView();
		List<MovieDetails> movieDetails = movieService.getAllReport();
		
		model.addObject("movieDetails", movieDetails);
	
		
		
		model.setViewName("report/moviesReport");

		return model;

	}
	@RequestMapping(value = "/getMoviesByUser", method = RequestMethod.GET)
	public ModelAndView getMovietByUser() {

		ModelAndView model = new ModelAndView();

		model.setViewName("report/getMoviesByUser");

		return model;

	}
	
	
	@RequestMapping(value = "/moviesByUser", method = RequestMethod.GET)
	public ModelAndView getMovieByUser(@RequestParam(value = "userId", required = false) long userId) {
		System.out.println("keyword  "+userId);
		ModelAndView model = new ModelAndView();
		List<MovieDetails> movieDetails = movieService.getMovieByUser(userId);
//		for(MovieDetails a: moviesDetails){
//			System.out.println(a.getTitle());
//		}
	
		
		model.addObject("movieDetails", movieDetails);
		
	int mov=movieDetails.size();
	System.out.println("size "+mov);
	model.addObject("mov", mov);
		model.setViewName("report/moviesReportByUser");

		return model;

	}
	
//	@RequestMapping(value="/userReport",method=RequestMethod.GET)
//	public ModelAndView userReport(){
//		ModelAndView model=new ModelAndView();
//		List<UserDetails> userReport=movieService.userReport();
//		
//		model.addObject("userReport", userReport);
//		
//		
//		model.setViewName("report/userReport");
//		return model;
//		
//	}
	
	@RequestMapping(value = "/getMoviesByGenre", method = RequestMethod.GET)
	public ModelAndView getMoviesByGenre() {

		ModelAndView model = new ModelAndView();

		model.setViewName("report/getMoviesByGenre");

		return model;

	}
	
	@RequestMapping(value = "/moviesByGenre", method = RequestMethod.GET)
	public ModelAndView moviesByGenre(@RequestParam(value = "genre", required = false) String genre) {
		System.out.println("keyword  "+genre);
		ModelAndView model = new ModelAndView();
		List<MovieDetails> movieDetails = movieService.getMovieByGenre(genre);
	
		
		model.addObject("movieDetails", movieDetails);
		

		model.setViewName("report/moviesReportByGenre");

		return model;

	}	
			
			
}
