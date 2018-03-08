package com.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.MovieDto;
import com.springmvc.dtohelper.MovieDtoHelper;
import com.springmvc.model.Movie;
import com.springmvc.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieService movieService;

	@Autowired
	MovieDtoHelper movieDtoHelper;

	/*
	 * @RequestMapping(value = "/movies", method = RequestMethod.GET) public
	 * List<Movie> getAllMovies() { List<Movie> movieDetails = (List<Movie>)
	 * movieService.getAll(); return movieDetails; }
	 */
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ModelAndView getAllMovies() {
		ModelAndView model = new ModelAndView();
		List<MovieDto> list = new ArrayList<MovieDto>();
		for (Movie movie : movieService.getAll()) {
			list.add((MovieDto) movieDtoHelper.modelToDto(movie));
		}
		model.addObject("list", list);
		model.setViewName("movies");
		return model;
	}

	/*
	 * @RequestMapping(value = "/movies", method = RequestMethod.GET) public
	 * ModelAndView getAllMovies() { ModelAndView model = new ModelAndView();
	 * List<Movie> movieDetails = (List<Movie>) movieService.getAll();
	 * model.addObject("movieDetails", movieDetails);
	 * model.setViewName("movies"); return model; }
	 */

	@RequestMapping("/hello")
	public ModelAndView mymethod() {
		ModelAndView modelAndView = new ModelAndView("hellopage");
		modelAndView.addObject("msg", "Hello First Spring");
		return modelAndView;
	}

	@RequestMapping("/message")
	public String passParametersWithModel(Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("spring", "mvc");
		model.addAttribute("message", "Baeldung");
		model.mergeAttributes(map);
		return "viewPage";
	}

	/*
	 * @RequestMapping("/hello") public ModelAndView mymethod() {
	 * 
	 * return new ModelAndView(viewName, model, status); }
	 * 
	 * @GetMapping("/goToViewPage") public ModelAndView
	 * passParametersWithModelAndView() { ModelAndView modelAndView = new
	 * ModelAndView("viewPage"); modelAndView.addObject("message", "Baeldung");
	 * return modelAndView; }
	 */
	/*
	 * @RequestMapping(value = "/movies/{mid}", method = RequestMethod.GET)
	 * public int findMovie(@PathVariable("mid") int mid) {
	 * 
	 * List<Rating> ratings= ratingService.findRating(mid);
	 * 
	 * int temp=0; for(Rating rating:ratings){ temp=rating.getRating()+temp; }
	 * int size=ratings.size(); int avg=temp/size;
	 * 
	 * //Movie movie = movieService.find(mid); //MovieDto movieDto = (MovieDto)
	 * movieDtoHelper.modelToDto(movie);
	 * 
	 * return avg; }
	 */

	@RequestMapping(value = "/movies/{title}", method = RequestMethod.GET)
	public MovieDto findMovie(@PathVariable("title") String title) {
		ModelAndView model = new ModelAndView();
		Movie movie = movieService.find(title);
		MovieDto movieDto = (MovieDto) movieDtoHelper.modelToDto(movie);
		model.addObject("movieDto",movieDto);
		model.setViewName("movies");
		return movieDto;
	}

}