package springMongo.MovieStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import springMongo.MovieStore.bean.Users;	

public interface UserRepository extends MongoRepository<Users, String>{
	
          
}
