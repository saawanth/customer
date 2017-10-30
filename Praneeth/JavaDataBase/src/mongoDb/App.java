package mongoDb;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
//MongoDb DataBase Crud Operations
public class App {
	  public static void main(String[] args) {

	    try {

		MongoClient mongo = new MongoClient("localhost", 27017);

		// if database doesn't exists, MongoDB will create it for you
		DB db = mongo.getDB("testdb");


		// if collection doesn't exists, MongoDB will create it for you
		DBCollection table = db.getCollection("user");

		
		// create a document to store key and value
		BasicDBObject document = new BasicDBObject();
		document.put("name", "Praneeth");
		document.put("age",23);
		document.put("createdDate", new Date());
		table.insert(document);

		/**** Find and display ****/
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "Praneeth");

		DBCursor cursor = table.find(searchQuery);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

		/**** Update ****/

		BasicDBObject query = new BasicDBObject();
		query.put("name", "Praneeth");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", "Praneeth_Updated");

		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);

		table.update(query, updateObj);

		/**** Find and display ****/
		BasicDBObject searchQuery2
		    = new BasicDBObject().append("name", "Praneeth-updated");

		DBCursor cursor2 = table.find(searchQuery2);

		while (cursor2.hasNext()) {
			System.out.println(cursor2.next());
		}

		/**** Done ****/
		System.out.println("Done");

	    } catch (MongoException e) {
		e.printStackTrace();
	    }

	  }
	}
