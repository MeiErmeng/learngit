package com.yiibai.MongoDBJDBC;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC{
   public static void main( String args[] ){
      try{   
         // ���ӵ� mongodb ����
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

         // ���ӵ����ݿ�
         MongoDatabase mongoDatabase = mongoClient.getDatabase("information");  
         System.out.println("Connect to database successfully");

         MongoCollection<Document> collection = mongoDatabase.getCollection("person");
         System.out.println("���� person ѡ��ɹ�");
       //ɾ�����з����������ĵ�  
         collection.deleteMany (Filters.eq("age", 20));   
         //�����鿴���  
         FindIterable<Document> findIterable = collection.find();  
         MongoCursor<Document> mongoCursor = findIterable.iterator();  
         while(mongoCursor.hasNext()){  
           System.out.println(mongoCursor.next());  
         }  
           
      }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     }
   }
}