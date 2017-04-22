package com.redis.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
  @RequestMapping(value="/find/{name}",method = RequestMethod.GET)
  public Product find(@PathVariable("name") String name) {
	  
	Product pers=productRepo.find(name);
	  return pers;
  }

  @RequestMapping(value="/findAll",method = RequestMethod.GET)
  public List<Object> findAll() {
	  
	List<Object> prods=productRepo.findAll();
	
	  return prods;
  }
  
  
  @RequestMapping(value="/findAllKeys",method = RequestMethod.GET)
  public Set<Object> keyset() {
	  
	Set<Object> keyset=productRepo.findKeySet();
	
	  return keyset;
  }
  
  
  @RequestMapping(value="/entryset",method = RequestMethod.GET)
  public Map entryset() {
	  
	Map entryset=productRepo.allEntries();
	
	  return entryset;
  }
  

  @RequestMapping(value="/hasKey/{name}",method = RequestMethod.GET)
  public boolean hasKey(@PathVariable("name") String name) {
	  
	boolean bool=productRepo.hasKey(name);
	
	  return bool;
  }
  

  @RequestMapping(value="/size",method = RequestMethod.GET)
  public long size() {
	  
	long size=productRepo.findSize();
	
	  return size;
  }
  
  @RequestMapping(value="/values",method = RequestMethod.GET)
  public List<Product> values() {
	  
	List<Product> values=productRepo.findValues();
	
	  return values;
  }
  
  
  @RequestMapping(value="/remove/{name}",method = RequestMethod.DELETE)
  public void delete(@PathVariable("name") String name) {
	  
	productRepo.remove(name);
	
	  
  }
  
  
}