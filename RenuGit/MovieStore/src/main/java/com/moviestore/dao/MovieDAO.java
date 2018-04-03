package com.moviestore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.moviestore.model.MovieDetails;

@Repository
public interface MovieDAO extends CrudRepository<MovieDetails, String> {

	@Query("Select m.movieTitle from MovieDetails m where m.genre = :genre ")
	List<MovieDetails> getMoviesWithRatingsByGenre(@Param("genre") String genre);

	@Query("Select m.movieTitle, avg(r.rating) from MovieDetails m join m.ratings r where m.genre = :genre and r.uSD.userID = :id ")
	List<MovieDetails> getMoviesWithRatingsByGenreAndId(@Param("genre") String genre, @Param("id") int id);

//	ORDER BY avg(r.rating)
	// order by avg(mr.rating)
	// + "order by avg(m.ratings.rating)"
	// Given a genre such as"action"
	// and a userId,return the top 5 movies for
	// that genre by average rating,
	// where the rating was made by other users within 5years (older and
	// younger) of the user's age.
}
