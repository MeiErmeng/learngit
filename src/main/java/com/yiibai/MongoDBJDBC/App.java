package com.yiibai.MongoDBJDBC;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
 
public class App {
	
	public static void main(String[] args) {
		try {
			//����MongoDB ������
			MongoClient mongoClient = 
					new MongoClient("localhost", 27017);
			//�������ݿ�
			MongoDatabase mDatabase = 
					mongoClient.getDatabase("information");  //test��ѡ
			 
			System.out.println("Connect to database successfully!");
			System.out.println("MongoDatabase inof is : "+mDatabase.getName());
		} catch (Exception e) {
			 System.err.println(
					 e.getClass().getName() + ": " + e.getMessage());
		}
	}
}