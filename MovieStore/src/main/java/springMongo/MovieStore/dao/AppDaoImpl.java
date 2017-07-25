package springMongo.MovieStore.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;

@Service
public class AppDaoImpl implements AppDao{

	MongoClient mongoClient  = null;
	MongoDatabase db = null;
	MongoCollection<Document> table = null;
	MongoCollection<Document> userscol = null;
	Document doc = null;
	List<Document> list = new ArrayList<Document>();
	@Override
	public List<Document> getUser(String user) {
		try{
			list.clear();
			getCollection();
			MongoCollection<Document> userscol =  this.userscol;
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("userName",user);
		BasicDBObject projection = new BasicDBObject();
		projection.put("Movieswatched.movieTitle", 1);
		projection.put("Movieswatched.rating", 1);
		projection.put("_id", 0);
		FindIterable<Document> find = userscol.find(searchQuery ).projection(projection);
		Iterator<Document> it = find.iterator();
		while(it.hasNext())
		{
			 doc = it.next();
			 list.add(doc);
		}
		return list;
		}
		finally
		{
			mongoClient.close();
		}
	}
	
	public Document getAvgRating(int movieId)
	{
		try{
			Document document = null;
			getCollection();
			MongoCollection<Document> table =  this.table;
			BasicDBObject dbobj = new BasicDBObject("$match", new BasicDBObject("movieId", movieId));
			AggregateIterable<Document> doc = table.aggregate(Arrays.asList(dbobj, Aggregates.project((Bson) new BasicDBObject("_id", 0).append(
					"avgrating", new BasicDBObject("$avg", "$Watchedby.rating") ))));
			document = doc.first();
			return document;
		}
		finally
		{
			mongoClient.close();
		}
	}

	public MongoCollection<Document> getCollection()
	{
		try{
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 db = mongoClient.getDatabase("4serv");
		 table = db.getCollection("moviestore");
		 userscol =  db.getCollection("users");
		return table;
		}
		finally{}
	}
}
