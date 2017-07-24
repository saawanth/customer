package SpringMongo.MovieStore.dao;

import java.util.List;

import org.bson.Document;

public interface  AppDao {
       public List<Document> getUser(String user);
       
       public Document getAvgRating(int movieId);
}
