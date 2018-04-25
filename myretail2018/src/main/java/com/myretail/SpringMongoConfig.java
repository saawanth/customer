package com.myretail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(basePackages = { "com.myretail.model", "com.myretail.repository" })
public class SpringMongoConfig extends AbstractMongoConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(SpringMongoConfig.class);

	@Value("${spring.application.name:myretail}")
	private String proAppName;

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;

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
		logger.info("mongo connection uri " + mongoUri);
		return new MongoClient(new MongoClientURI(mongoUri));
	}

	@Override
	protected String getDatabaseName() {
		return mongoDB;
	}	
}