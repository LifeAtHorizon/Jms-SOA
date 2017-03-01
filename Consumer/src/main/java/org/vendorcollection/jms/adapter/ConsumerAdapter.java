package org.vendorcollection.jms.adapter;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;


@Component
public class ConsumerAdapter {

	// Define a logger 
	private static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ConsumerAdapter.class.getName());
	
	public void sendToMongo(String jsonString) {
		logger.info("Send to mongodb is called");
		MongoClient mongoclient = new MongoClient();
		/*
		 * This will create a db Object - And a database in the mongodb for
		 * Vendors 
		 */
		DB db = mongoclient.getDB("Vendor");
		// By using the db object in the db we will can query the vendor contacts from the mongodb
		DBCollection ContactCollection = db.getCollection("contact");
		logger.info("Converting json into DB Object");
		
		DBObject dbobject = (DBObject)JSON.parse(jsonString);
		ContactCollection.insert(dbobject);
		logger.info("sent to mongodb");
	}

}
