package com.srujanonit.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESRestClient {

	@Bean
	public RestClient restClient(){
		return  RestClient.builder(
		        new HttpHost("localhost", 9200, "http")).build();
	}
	
}
