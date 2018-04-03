package com.moviestore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moviestore.model.Rating;

public interface RatingDAO extends CrudRepository<Rating, Integer> {

	@Query("Select r.mSD.movieTitle, r.rating from Rating r where r.uSD.userID = :uID")
	List<Rating> getMoviesById(@Param("uID") int uID);

	@Query("Select avg(r.rating) from Rating r where r.mSD.movieID = :mID")
	List<Rating> getRatingById(@Param("mID") int mID);
}
