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
 * һ��mongodb����ϵͳ
 * ����1 ������Ӳ���
 *
 * ����2 ����ɾ������
 *
 * ����3 �����޸Ĳ���
 *
 * ����4 �����ѯ����
 */
public class MongoDemo {


    /**
     * �����ѯ����

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
        //java.io.InputStreamReader�̳���Reader��
        String read = null;
//        System.out.print("�������ݣ�");
        try {
            read = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("�������ݣ�"+read);
        return read;
    }

    public static void main(String[] args) {
        MongoDemo mongoDemo = new MongoDemo();
        MongoClient mongoClient = new MongoClient("localhost",27017);

        System.out.println("������Ҫ���������ݿ�");
        String dbs = mongoDemo.systemIn();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbs);

        System.out.println("������Ҫ�����ļ���");
        String cs = mongoDemo.systemIn();
        MongoCollection<Document> collection = mongoDatabase.getCollection(cs);

        Boolean flag = true;
        while(flag){
            System.out.println("1:����\n,2:ɾ��\n,3:�޸�\n,4:��ѯ\n,5:�˳�\n");
            System.out.println("������Ҫ���еĲ���");
            String num = mongoDemo.systemIn();

            int i = Integer.parseInt(num);
            switch (i){
                case 1:
                    System.out.println("��Ҫ��ӵ�����Ϊ��");
                    break;
                case 2:
                    System.out.println("��Ҫɾ��������Ϊ��");
                    break;
                case 3:
                    System.out.println("��Ҫ�޸ĵ�����Ϊ��");
                    break;
                case 4:
                    System.out.println("��Ҫ��ѯ������Ϊ��");
                    String scan = mongoDemo.scan(collection);
                    System.out.println(scan);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("������1-4,����ѡ��");
            }
        }


    }
}
