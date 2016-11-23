package org.movie.store.repository;

import org.movie.store.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends BaseRepository<User, Long> {

}
