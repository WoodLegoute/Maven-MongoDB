package edu.citytech.cst.driver;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class _DriverQuery {
	
	
	public static void main(String... args) { 
		 
		// try catch resource Java 1.7
        try (MongoClient client = new MongoClient()) { 
 
            MongoDatabase db = client.getDatabase("ratesdb"); 
            MongoCollection<Document> coll = db.getCollection("restaurants"); 
 
            //Bson sort = Sorts.ascending("student_id", "score"); 
            //Bson filterB = Filters.eq("borough" , "Bronx");
            Bson filterC = Filters.eq("cuisine" , "American");
            Bson filterZ = Filters.eq("address.zipcode" , "10460");
            Bson filters = Filters.and(filterZ,filterC);
 
            List<Document> all = coll.find(filters).into(new ArrayList<Document>()); 
            
            all.forEach(e -> {
            	System.out.println(e);
            }); 
                       
        } 
    } 
}
