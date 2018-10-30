package com.yiibai.MongoDBJDBC;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class CreateCollection {
	public static void main(String[] args) {
		try {
            // mongodb server
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //databases
            MongoDatabase database = mongoClient.getDatabase("test");
 
			MongoCollection<Document> coll = database.getCollection("myTestCollection");
 
            System.out.println("Collection created successfully");
            System.out.println("��ǰ���ݿ��е����м����ǣ�");
            for (String name : database.listCollectionNames()) {
                System.out.println(name);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
} 
