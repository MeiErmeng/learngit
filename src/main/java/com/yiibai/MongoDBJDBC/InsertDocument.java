package com.yiibai.MongoDBJDBC;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 
public class InsertDocument {
	public static void main(String[] args) {
		 try {
	            // mongodb server
	            MongoClient mongoClient = new MongoClient("localhost", 27017);
	            //databases
	            MongoDatabase database = mongoClient.getDatabase("test");
 
	            System.out.println("Collection created successfully");
	            System.out.println("当前数据库中的所有集合是：");
	            for (String name : database.listCollectionNames()) {
	                System.out.println(name);
	            }
	            MongoCollection<Document> coll = database.getCollection("test");
	            System.out.println("Collection test selected successfully");
	            MongoCollection<Document> collection = database.getCollection("test");
 
Document document = new Document("_id", 1999)
						   .append("title", "MongoDB Insert Demo")
	                    .append("description","database")
	                    .append("likes", 30)
	                    .append("by", "demo point")
	                    .append("url", "http://www.demo.com/mongodb/");
	            collection.insertOne(document);
	            collection.find().forEach(printBlock);
	            System.out.println("Document inserted successfully");
	        } catch (Exception e) {
	            System.err.println(e.getClass().getName() + ": " + e.getMessage());
	        }
	    }

	    static Block<Document> printBlock = new Block<Document>() {
	        public void apply(final Document document) {
	            System.out.println(document.toJson());
	        }
	    };
}
