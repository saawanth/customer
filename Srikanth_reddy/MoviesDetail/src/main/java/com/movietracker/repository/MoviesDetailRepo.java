package com.movietracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.movietracker.domain.MovieDetails;

public interface MoviesDetailRepo extends CrudRepository<MovieDetails, String> {

	MovieDetails findByTitle(String title);
	@Query(value="SELECT * FROM movie_details WHERE title LIKE CONCAT('%',:title,'%') ", nativeQuery=true)
	List<MovieDetails> MovieByTitle(@Param("title")String title);
	@Query(value="select movieId,addedBy,title,rating,genre, username  from users_details u, movie_details m where u.userId=m.addedBy and userId=?1", nativeQuery=true)
	List<MovieDetails> moviesByUser(long userId);
	@Query(value="SELECT AVG( m.rating ) AS avra, m.movieId, m.genre,m.addedBy,m.movieId,m.title,m.rating FROM movie_details m , users_details u WHERE m.addedBy = u.userId and m.genre LIKE CONCAT('%',:genre,'%')  GROUP BY m.movieId Order By AVG( m.rating ) Desc", nativeQuery=true)
	List<MovieDetails> moviesByGenre(@Param("genre")String genre);


}
