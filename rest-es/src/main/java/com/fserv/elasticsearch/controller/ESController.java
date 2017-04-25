package com.fserv.elasticsearch.controller;

import java.io.IOException;
import java.util.Collections;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ESController {

  @Autowired
  private RestClient client;

  @RequestMapping("/")
  public String index() {
    // index a document
    HttpEntity entity =
        new NStringEntity("{\n" + "    \"name\" : \"react js: From Beginner to Professional\",\n"
            + "    \"price\" : \"50.00\",\n"
            + "    \"description\" : \"Learn react Framework 2 in just a few hours!\",\n"
            + "    \"quantity\" : \"1\"\n" + "}", ContentType.APPLICATION_JSON);


    Response response = null;
    String out = null;
    try {


      response = client.performRequest("POST", "/ecommerce/item/3",
          Collections.<String, String>emptyMap(), entity);
      // response = client.restClient().performRequest("GET", "/ecommerce/_search?q=name:zend",
      // Collections.singletonMap("pretty", "true"));
      out = EntityUtils.toString(response.getEntity());
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return out;
  }
}
