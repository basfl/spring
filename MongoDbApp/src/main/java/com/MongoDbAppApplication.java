package com;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@SpringBootApplication
public class MongoDbAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntx = SpringApplication.run(MongoDbAppApplication.class, args);
		MongoOperations mongoOperation = (MongoOperations) cntx.getBean(MongoTemplate.class);
		
		Set<String> collections = mongoOperation.getCollectionNames();
		for (String collection : collections) {
			System.out.println(collection);
		}
	}

	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1");
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "test");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}
}
