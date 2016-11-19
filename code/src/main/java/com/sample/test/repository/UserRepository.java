package com.sample.test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.test.model.Users;

@Repository
@Transactional
public interface UserRepository extends BaseRepository<Users, Long>{
  
  @Query("select euser from Users AS euser left join fetch euser.userRatings where euser.id=:id")
  public Users getSpecificUser(@Param("id") long id);

}
