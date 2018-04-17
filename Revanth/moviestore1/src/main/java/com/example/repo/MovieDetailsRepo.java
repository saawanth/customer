package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.MovieDetails;

public interface MovieDetailsRepo extends JpaRepository<MovieDetails, Integer> {

	@Query(value = "Select m from MovieDetails m " + "Where m.genre = :genre")
	List<MovieDetails> getMoviesByGenre(@Param("genre") String genre);

	@Query(value = "Select m from MovieDetails as m " + "join fetch m.userDetails as u "
			+ "Where m.genre = :genre and u.user_id = :id")
	List<MovieDetails> getMoviesByGenreAndId(@Param("genre") String genre, @Param("id") int id);
}
