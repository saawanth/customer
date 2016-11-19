package com.sample.test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.test.model.Movies;
import com.sample.test.model.Users;

@Repository
@Transactional
public interface UserRepository extends BaseRepository<Users, Long>{
  
  @Query("select euser from Users AS euser left join fetch euser.userRatings where euser.id=:id")
  public Users getSpecificUser(@Param("id") long id);
  
  @Query("select m from Movies AS m left join fetch m.userRatings where m.id=:id")
  public Movies getMoviesAvgById(@Param("id") long id);

}
