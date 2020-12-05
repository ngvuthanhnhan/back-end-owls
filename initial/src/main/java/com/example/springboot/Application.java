package com.example.springboot;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class })

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

//		test

		try {

			MongoClient mongoClient = new MongoClient(new MongoClientURI(
					"mongodb+srv://cnpmnc:cnpmnc@vincent.nbybn.mongodb.net/cnpmnc?retryWrites=true&w=majority"));
			MongoDatabase database = mongoClient.getDatabase("cnpmnc");
			System.out.println("connect success");
			MongoCollection<Document> collection = database.getCollection("books");

			FindIterable<Document> iterDoc = collection.find();
			Iterator<Document> it = iterDoc.iterator();
			System.out.println("--------------- All book ------------------");

			while (it.hasNext()) {
				System.out.println(it.next().get("name"));
				System.out.println(it.next());
			}
			// add to linkedlist
//			List<Document> myList =  new java.util.ArrayList<Document>();

		}

		catch (Exception e) {
//			 TODO: handle exception
			System.out.println(e);
		}
	}

}
