package org.movie.store.service;

import java.util.ArrayList;
import java.util.List;

import org.movie.store.dto.UserDto;
import org.movie.store.dto.UserMoviesDto;
import org.movie.store.dto.UserRatingDto;
import org.movie.store.dto.helper.MovieDtoHelper;
import org.movie.store.dto.helper.UserDtoHelper;
import org.movie.store.model.Movie;
import org.movie.store.model.User;
import org.movie.store.model.UserRating;
import org.movie.store.repository.UserRatingRepository;
import org.movie.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserDto> implements UserService {

	@Autowired
	public UserServiceImpl(UserRepository repository, UserDtoHelper dtoHelper) {
		super(repository, dtoHelper);
	}

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private UserRatingRepository userRatingRepo;

	@Autowired
	private MovieDtoHelper movieDtoHelper;

	/*
	 * Given a userId, return all movies that user has watched and the total
	 * count, as well as the rating for that movie.
	 */
	@Override
	public UserMoviesDto getMoviesWatchedByUser(long userId) {
		User user = userrepo.findOne(userId);
		UserMoviesDto usrMoviesDto = null;
		if (user != null) {
			UserDto userDto = dtoHelper.buildDto(user);

			List<UserRating> usrRatings = userRatingRepo.getMoviesWatchedByUser(userId);

			usrMoviesDto = new UserMoviesDto();
			usrMoviesDto.setUser(userDto);

			List<UserRatingDto> userRatingdtos = new ArrayList<UserRatingDto>();
			if (usrRatings != null) {
				for (UserRating usrRating : usrRatings) {

					UserRatingDto userratingdto = new UserRatingDto();
					userratingdto.setRating(usrRating.getRating());

					Movie movie = usrRating.getMovie();
					userratingdto.setMovie(movieDtoHelper.buildDto(movie));

					userRatingdtos.add(userratingdto);
				}
			}

			usrMoviesDto.setUserRatings(userRatingdtos);
			usrMoviesDto.setNumOfMoviesWatched(userRatingdtos.size());
		}
		return usrMoviesDto;
	}
}