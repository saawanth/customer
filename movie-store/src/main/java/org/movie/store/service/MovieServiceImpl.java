package org.movie.store.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.movie.store.dto.MovieDto;
import org.movie.store.dto.helper.MovieDtoHelper;
import org.movie.store.model.Genre;
import org.movie.store.model.Movie;
import org.movie.store.model.User;
import org.movie.store.repository.MovieRepository;
import org.movie.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
		Object movieObj = ((MovieRepository) repository).findMovieAvgRating(movieId);
		Object[] movieObjVals = (Object[]) movieObj;

		Movie movie = (Movie) movieObjVals[0];
		Double avgRating = (Double) movieObjVals[1];
		movie.setAvgRating(avgRating);

		return dtoHelper.buildDto(movie);
	}

	@Override
	public List<MovieDto> findTop5MoviesByGenre(long userId, Genre genre) {
		User user = userrepo.findOne(userId);
		Date dob = user.getDateOfBirth();

		// Sort sort = new Sort(new Order(Direction.DESC, "rating"));
		PageRequest pageReq = new PageRequest(0, 5);

		Calendar dobCal = Calendar.getInstance();
		dobCal.setTime(dob);
		dobCal.add(Calendar.YEAR, -5);

		Calendar dobCal2 = Calendar.getInstance();
		dobCal2.setTime(dob);
		dobCal2.add(Calendar.YEAR, 5);

		List<Object> t5Movies = ((MovieRepository) repository).findTop5MoviesByGenre(userId, genre,
				new java.sql.Date(dobCal.getTimeInMillis()), new java.sql.Date(dobCal2.getTimeInMillis()), pageReq);

		List<Movie> top5Movies = new ArrayList<Movie>();

		for (Object obj : t5Movies) {
			Object[] objVls = (Object[]) obj;
			Long movieId = (Long) objVls[0];
			Double avgRating = (Double) objVls[1];

			Movie movie = repository.findOne(movieId);
			movie.setAvgRating(avgRating);
			top5Movies.add(movie);
		}

		return dtoHelper.buildDto(top5Movies);
	}

}
