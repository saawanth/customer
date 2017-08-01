package springMongo.MovieStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import springMongo.MovieStore.bean.Users;	

@Repository
public interface UserRepository extends MongoRepository<Users, String>, UserRepositoryCustom{
	
          public Users findByuserName(String name);
          
}
