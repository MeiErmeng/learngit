package com.yiibai.MongoDBJDBC;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.BSON;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 2018/10/23.
 * 一个mongodb管理系统
 * 输入1 进入添加操作
 *
 * 输入2 进入删除操作
 *
 * 输入3 进入修改操作
 *
 * 输入4 进入查询操作
 */
public class MongoDemo {


    /**
     * 输入查询条件

     */
    public String scan(MongoCollection mongoCollection){


        FindIterable findIterable = mongoCollection.find();
//        String s = findIterable.toString();
        MongoCursor iterator = findIterable.iterator();

        StringBuffer sb = new StringBuffer();

        while (iterator.hasNext()){
            Object next = iterator.next();
            String s = next.toString();
            sb.append(s);
        }


        return new String(sb);


    }

    public void insertOne(String key,String value){


    }


    public String systemIn(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        //java.io.InputStreamReader继承了Reader类
        String read = null;
//        System.out.print("输入数据：");
        try {
            read = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("输入数据："+read);
        return read;
    }

    public static void main(String[] args) {
        MongoDemo mongoDemo = new MongoDemo();
        MongoClient mongoClient = new MongoClient("localhost",27017);

        System.out.println("输入你要操作的数据库");
        String dbs = mongoDemo.systemIn();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbs);

        System.out.println("输入你要操作的集合");
        String cs = mongoDemo.systemIn();
        MongoCollection<Document> collection = mongoDatabase.getCollection(cs);

        Boolean flag = true;
        while(flag){
            System.out.println("1:增加\n,2:删除\n,3:修改\n,4:查询\n,5:退出\n");
            System.out.println("输入你要进行的操作");
            String num = mongoDemo.systemIn();

            int i = Integer.parseInt(num);
            switch (i){
                case 1:
                    System.out.println("你要添加的内容为：");
                    break;
                case 2:
                    System.out.println("你要删除的内容为：");
                    break;
                case 3:
                    System.out.println("你要修改的内容为：");
                    break;
                case 4:
                    System.out.println("你要查询的内容为：");
                    String scan = mongoDemo.scan(collection);
                    System.out.println(scan);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("请输入1-4,进行选择");
            }
        }


    }
}
