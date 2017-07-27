package springMongo.MovieStore.repository;

import java.util.List;

import springMongo.MovieStore.bean.Result;
import springMongo.MovieStore.bean.Users;

public interface UserRepositoryCustom {

	public List<Result> findByAvgRating(String name);
}
