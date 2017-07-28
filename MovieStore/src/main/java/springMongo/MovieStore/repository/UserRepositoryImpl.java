package springMongo.MovieStore.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import springMongo.MovieStore.bean.Movieswatched;
import springMongo.MovieStore.bean.Result;
import springMongo.MovieStore.bean.Users;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Result> findByAvgRating(Integer id) {
		TypedAggregation<Users> agg = newAggregation(Users.class,unwind("movieswatched"),match(Criteria.where("movieswatched.mid").is(id)), group("movieswatched.mid").avg("movieswatched.rating").as("avgrating"), project("avgrating"));
		AggregationResults<Result> users = mongoTemplate.aggregate(agg, Users.class,Result.class);
		List<Result> userslis = users.getMappedResults();
		return userslis;
	}
}
