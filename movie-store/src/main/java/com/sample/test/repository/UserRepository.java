package com.sample.test.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.test.model.User;

@Repository
@Transactional
public interface UserRepository extends BaseRepository<User, Long> {

}
