package com.sample.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.test.dto.UserDto;
import com.sample.test.dto.UserMoviesDto;
import com.sample.test.dto.UserRatingDto;
import com.sample.test.dto.helper.MovieDtoHelper;
import com.sample.test.dto.helper.UserDtoHelper;
import com.sample.test.model.Movie;
import com.sample.test.model.User;
import com.sample.test.model.UserRating;
import com.sample.test.repository.UserRatingRepository;
import com.sample.test.repository.UserRepository;

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

		List<UserRating> usrRatings = userRatingRepo.getMoviesWatchedByUser(userId);

		UserMoviesDto usrMoviesDto = new UserMoviesDto();
		UserDto userDto = new UserDto();
		userDto.setFirstname(user.getFirstname());
		usrMoviesDto.setUserDto(userDto);

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
		return usrMoviesDto;

	}
}