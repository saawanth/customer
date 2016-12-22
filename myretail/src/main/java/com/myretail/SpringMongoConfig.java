package com.myretail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = { "com.myretail.model", "com.myretail.repository" })
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.application.name:myretail}")
	private String proAppName;

	@Value("${spring.data.mongodb.host:127.0.0.1}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port:27017}")
	private String mongoPort;

	@Value("${spring.data.mongodb.database:mongodb}")
	private String mongoDB;

	@Override
	public MongoMappingContext mongoMappingContext() throws ClassNotFoundException {
		return super.mongoMappingContext();
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(mongoHost + ":" + mongoPort);
	}

	@Override
	protected String getDatabaseName() {
		return mongoDB;
	}
}