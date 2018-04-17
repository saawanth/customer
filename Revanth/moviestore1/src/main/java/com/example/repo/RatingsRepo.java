package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Ratings;

@Repository
public interface RatingsRepo extends CrudRepository<Ratings, Integer> {

	@Query(value = "select r.movie_rating as rating, r.movieDetails.movie_title as title from Ratings r "
			+ "WHERE r.userDetails.user_id=:id")
	List<Ratings> getMoviesById(@Param("id") int id);

	@Query(value = "SELECT avg(r.movie_rating) FROM Ratings r " + "WHERE r.movieDetails.movie_id = :id")
	List<Ratings> getAvgRating(@Param("id") int id);
}
