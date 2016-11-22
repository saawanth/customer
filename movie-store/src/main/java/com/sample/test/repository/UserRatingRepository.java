package com.sample.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.test.model.UserRating;
import com.sample.test.model.User;

@Repository
@Transactional
public interface UserRatingRepository extends BaseRepository<User, Long> {

	/**
	 * Given a userId, return all movies that user has watched and the total
	 * count, as well as the rating for that movie.
	 * 
	 * @param id
	 * @return
	 */
	@Query("SELECT ur FROM UserRating ur LEFT JOIN FETCH ur.movie WHERE ur.user.id=:id ")
	public List<UserRating> getMoviesWatchedByUser(@Param("id") long id);
}
