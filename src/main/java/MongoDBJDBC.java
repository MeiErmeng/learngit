
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
public class MongoDBJDBC{
   public static void main( String args[] ){
      try{   
       // ���ӵ� mongodb ����
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
       
         // ���ӵ����ݿ�
         MongoDatabase mongoDatabase = mongoClient.getDatabase("information");  
       System.out.println("Connect to database successfully");
       
       MongoCollection<Document> collection = mongoDatabase.getCollection("person1");
       System.out.println("���� person1 ѡ��ɹ�");
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