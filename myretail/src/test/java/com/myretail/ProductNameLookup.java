package com.myretail;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductNameLookup {

	private static final String resourceUrl = "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

	public static void main(String[] args) {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);

		RestTemplate restTemplate = new RestTemplate(requestFactory);

		ResponseExtractor<String> resExtractor = new ResponseExtractor<String>() {
			public String extractData(ClientHttpResponse response) throws IOException {
				return lookupValueInJson(response.getBody(), "product", "item", "product_description", "title");
			}
		};
		
		// http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,
		// bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_st
		// atistics
		
		System.out.println(restTemplate.execute(resourceUrl, HttpMethod.GET, null, resExtractor, 13860428));
	}
	
	
	private static String lookupValueInJson(InputStream responseAsStream, String... keysToLookup)
			throws IOException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(responseAsStream);
		String responseStr = null;
		for (String keyToLookup : keysToLookup) {
			JsonNode lookedupJsonNode = jsonNode.get(keyToLookup);
			if (lookedupJsonNode != null) {
				jsonNode = lookedupJsonNode;
				responseStr = jsonNode.asText();
			} else {
				responseStr = null;
				break;
			}
		}
		return responseStr;
	}

}
