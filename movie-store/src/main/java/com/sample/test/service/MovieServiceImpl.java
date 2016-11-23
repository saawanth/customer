package com.sample.test.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.sample.test.dto.MovieDto;
import com.sample.test.dto.helper.MovieDtoHelper;
import com.sample.test.model.Genre;
import com.sample.test.model.Movie;
import com.sample.test.model.User;
import com.sample.test.repository.MovieRepository;
import com.sample.test.repository.UserRepository;

@Service
@Transactional
public class MovieServiceImpl extends BaseServiceImpl<Movie, Long, MovieDto> implements MovieService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	public MovieServiceImpl(MovieRepository repository, MovieDtoHelper dtoHelper) {
		super(repository, dtoHelper);
	}

	@Override
	public MovieDto findMovieWithAvgRating(long movieId) {
		Movie movie = repository.findOne(movieId);
		Integer rating = ((MovieRepository) repository).findMovieAvgRating(movieId);
		movie.setRating(rating);
		return dtoHelper.buildDto(movie);
	}

	@Override
	public List<MovieDto> findTop5MoviesByGenre(long userId, Genre genre) {
		User user = userrepo.findOne(userId);
		Date dob = user.getDateOfBirth();

		Sort sort = new Sort(new Order(Direction.DESC, "rating"));
		PageRequest pageReq = new PageRequest(0, 5, sort);

		Calendar dobCal = Calendar.getInstance();
		dobCal.setTime(dob);
		dobCal.add(Calendar.YEAR, -5);

		Calendar dobCal2 = Calendar.getInstance();
		dobCal2.setTime(dob);
		dobCal2.add(Calendar.YEAR, 5);

		List<Movie> top5Movies = ((MovieRepository) repository).findTop5MoviesByGenre(userId, genre,
				new java.sql.Date(dobCal.getTimeInMillis()), new java.sql.Date(dobCal2.getTimeInMillis()), pageReq);

		return dtoHelper.buildDto(top5Movies);
	}

}
