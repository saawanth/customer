package org.movie.store.repository;

import java.sql.Date;
import java.util.List;

import org.movie.store.model.Genre;
import org.movie.store.model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MovieRepository extends BaseRepository<Movie, Long> {

	/**
	 * Given a parameter of "movieId", return its average rating.
	 * 
	 * @param id
	 * @return
	 */
	@Query("SELECT m, AVG(ur.rating) as avgRating FROM Movie m INNER JOIN m.userRatings ur where m.id=:id")
	public Object findMovieAvgRating(@Param("id") long id);

	/**
	 * Given a genre such as "action" and a userId, return the top 5 movies for
	 * that genre by average rating, where the rating was made by other users
	 * within 5 years (older and younger) of the user's age.
	 * 
	 * @param userId
	 * @param genre
	 * @return
	 */
	@Query("SELECT m.id AS id, AVG(ur.rating) AS avgRating FROM Movie AS m INNER JOIN  m.userRatings AS ur INNER JOIN ur.user AS u "
			+ "WHERE m.genre=:genre AND u.id <>:userId AND u.dateOfBirth BETWEEN :dobStart AND :dobEnd GROUP BY m ORDER BY avgRating DESC ")
	public List<Object> findTop5MoviesByGenre(@Param("userId") long userId, @Param("genre") Genre genre,
			@Param("dobStart") Date dobStart, @Param("dobEnd") Date dobEnd, Pageable pageable);

}
