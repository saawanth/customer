package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Movie;
import com.springmvc.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		List<Movie> movieDetails = (List<Movie>) movieService.getAll();
		return movieDetails;
	}

	/*@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		ModelAndView model = new ModelAndView();
		List<Movie> movieDetails = (List<Movie>) movieService.getAll();
		model.addObject("movieDetails", movieDetails);
		model.setViewName("movies/displaymovies");
		return movieDetails;
	}*/
	@RequestMapping("/hello")
	public ModelAndView mymethod() {
		return new ModelAndView("hellopage", "msg", "Hello First Spring");
	}
	/*
	 * @RequestMapping(value = "/movies/{mid}", method = RequestMethod.GET) public
	 * int findMovie(@PathVariable("mid") int mid) {
	 * 
	 * List<Rating> ratings= ratingService.findRating(mid);
	 * 
	 * int temp=0; for(Rating rating:ratings){ temp=rating.getRating()+temp; } int
	 * size=ratings.size(); int avg=temp/size;
	 * 
	 * //Movie movie = movieService.find(mid); //MovieDto movieDto = (MovieDto)
	 * movieDtoHelper.modelToDto(movie);
	 * 
	 * return avg; }
	 */
	/*
	 * @RequestMapping(value = "/movies/{title}", method = RequestMethod.GET) public
	 * MovieDto findMovie(@PathVariable("title") String title) { Movie movie =
	 * movieService.find(title); MovieDto movieDto = (MovieDto)
	 * movieDtoHelper.modelToDto(movie); return movieDto; }
	 */

}