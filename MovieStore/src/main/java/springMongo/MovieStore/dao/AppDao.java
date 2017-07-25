package springMongo.MovieStore.dao;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;

public interface  AppDao {
       public List<Document> getUser(String user);
       
       public Document getAvgRating(int movieId);
}
