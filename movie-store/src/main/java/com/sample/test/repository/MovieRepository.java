package com.sample.test.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.test.model.Genre;
import com.sample.test.model.Movie;

@Repository
@Transactional
public interface MovieRepository extends BaseRepository<Movie, Long> {

	/**
	 * Given a parameter of "movieId", return its average rating.
	 * 
	 * @param id
	 * @return
	 */
	@Query("SELECT m, AVG(ur.rating) as rating FROM Movie m LEFT JOIN FETCH m.userRatings ur where m.id=:id GROUP BY m ")
	public Movie findMovieWithAvgRating(@Param("id") long id);

	/**
	 * Given a genre such as "action" and a userId, return the top 5 movies for
	 * that genre by average rating, where the rating was made by other users
	 * within 5 years (older and younger) of the user's age.
	 * 
	 * @param userId
	 * @param genre
	 * @return
	 */
	@Query("SELECT m, AVG(ur.rating) AS rating FROM UserRating ur JOIN ur.user AS u JOIN ur.movie AS m "
			+ "WHERE m.genre=:genre AND u.id <>:userId AND u.dateOfBirth BETWEEN :dobStart AND :dobEnd GROUP BY m ")
	public List<Movie> findTop5MoviesByGenre(@Param("userId") long userId, @Param("genre") Genre genre,
			@Param("dobStart") Date dobStart, @Param("dobEnd") Date dobEnd, Pageable pageable);

}
