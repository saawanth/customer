package com.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dtohelper.DtoHelper;
import com.springmvc.dtohelper.MovieDtoHelper;
import com.springmvc.dtohelper.RatingDtoHelper;
import com.springmvc.model.Movie;
import com.springmvc.model.Rating;
import com.springmvc.model.User;
import com.springmvc.service.MovieService;
import com.springmvc.service.MovieServiceImpl;
import com.springmvc.service.RatingService;
import com.springmvc.service.UserService;
import com.springmvc.dao.MovieDao;
import com.springmvc.dto.MovieDto;
import com.springmvc.dto.UserDto;

@RestController
public class MovieRestController {
	ArrayList<Rating> rates = null;
	@Autowired
	UserService userService;
	@Autowired
	MovieService movieService;
	@Autowired
	RatingService ratingService;
	
	@Autowired
	MovieDtoHelper movieDtoHelper;
	@Autowired
	RatingDtoHelper ratingDtoHelper;
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<MovieDto> getAllMovies() {
		List<MovieDto> list = new ArrayList<MovieDto>();
		for (Movie movie : movieService.getAll()) {
			list.add((MovieDto) movieDtoHelper.modelToDto(movie));
		}
		return list;
	}
	
	@RequestMapping(value = "/movies/{mid}", method = RequestMethod.GET)
	public int findMovie(@PathVariable("mid") int mid) {
		
		List<Rating> ratings= ratingService.findRating(mid);
		
		int temp=0;
		for(Rating rating:ratings){
			temp=rating.getRating()+temp;
		}
		int size=ratings.size();
		int avg=temp/size;
		
		Movie movie = movieService.find(mid);
		MovieDto movieDto =  (MovieDto) movieDtoHelper.modelToDto(movie);

		return avg;
	}
	
	
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public ResponseEntity<MovieDto> insertMovie( @RequestBody final MovieDto movieDto){
		
		Movie movie = (Movie) movieDtoHelper.dtoToModel(movieDto);
		
		MovieDto movieDto1 = (MovieDto) movieDtoHelper.modelToDto(movieService.insert(movie));
		
		return new ResponseEntity<>(movieDto1, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/movies/{mid}", method = RequestMethod.PUT)
	public ResponseEntity<MovieDto> updateMovie(@PathVariable("mid") int mid, @RequestBody MovieDto movieDto){
		Movie movie = movieService.find(mid);
		movie.setMid(movieDto.getMid());
		movie.setGenre(movieDto.getGenre());
		movie.setMoviename(movie.getMoviename());
		movieService.update(movie);
		
		return new ResponseEntity<>(movieDto, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/movies/{mid}", method = RequestMethod.DELETE)
	public MovieDto deleteMovie(@PathVariable("mid") int mid){
		Movie movie =  movieService.delete(mid);
		return (MovieDto) movieDtoHelper.modelToDto(movie);
	}
	
	
}
