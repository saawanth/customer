package com.redis.controller;

import java.util.Map;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redis.model.Product;
import com.redis.repo.ProductRepository;

@RestController
public class RedisController {

	@Autowired
	ProductRepository productRepo;

  @RequestMapping(value="/index",method = RequestMethod.POST)
  public ResponseEntity<Product> index(@RequestBody final Product product) {
	  
	  productRepo.saveProduct(product);
	  return new ResponseEntity<>(product,HttpStatus.OK) ;
  }
  @RequestMapping(value="/read/{name}",method = RequestMethod.GET)
  public Product read(@PathVariable("name") String name) {
	  
	Product pers=productRepo.find(name);
	  return pers;
  }

}