package com.redis.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ResponseEntity<Product> index(@RequestBody final Product product) {
		productRepo.saveProduct(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	public Product find(@PathVariable("name") String name) {

		Product pers = productRepo.find(name);
		return pers;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object findAll() {

		List<Object> mappedHash = productRepo.findAll();
		return mappedHash;
	}

	/*
	 * @RequestMapping(value="/findAll",method = RequestMethod.GET) public
	 * List<Object> findAll() {
	 * 
	 * List<Object> prods=productRepo.findAll();
	 * 
	 * return prods; }
	 */

	@RequestMapping(value = "/findAllKeys", method = RequestMethod.GET)
	public Set<Object> keyset() {

		Set<Object> keyset = productRepo.findKeySet();

		return keyset;
	}

	@RequestMapping(value = "/entryset", method = RequestMethod.GET)
	public Map entryset() {

		Map entryset = productRepo.allEntries();

		return entryset;
	}

	@RequestMapping(value = "/hasKey/{name}", method = RequestMethod.GET)
	public boolean hasKey(@PathVariable("name") String name) {
		boolean bool = productRepo.hasKey(name);
		return bool;
	}

	@RequestMapping(value = "/size", method = RequestMethod.GET)
	public long size() {
		long size = productRepo.findSize();
		return size;
	}

	@RequestMapping(value = "/values", method = RequestMethod.GET)
	public List<Product> values() {
		List<Product> values = productRepo.findValues();
		return values;
	}

	@RequestMapping(value = "/remove/{name}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("name") String name) {
		productRepo.remove(name);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Product> insert(@RequestBody final Product product) {
		productRepo.saveProduct1(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/findMappedObject/{name}", method = RequestMethod.GET)
	public Object findMappedObjects(@PathVariable("name") String name) {
		Product product = productRepo.findMapObject(name);
		return product;
	}

	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public Object clear(@RequestParam("cacheKey") String cacheKey) {
		productRepo.clear();
		return "Product cache ceared";
	}

	
	@RequestMapping(value = "/zadd", method = RequestMethod.POST)
	public Object zadd(@RequestBody Product product) {
		productRepo.sortedSet(product);
		return "Product added ";
	}
	

	@RequestMapping(value = "/zgetAll", method = RequestMethod.GET)
	public Set<Product> zgetAll() {
			Set<Product> products=productRepo.zGet();
			return products;
	}
	

	@RequestMapping(value = "/zcard", method = RequestMethod.GET)
	public long zcard() {
			long score=productRepo.zcard();
			return score;
	}
	
	@RequestMapping(value = "/zget", method = RequestMethod.GET)
	public Set zget(@RequestParam(value="score") int score ) {
		 
			return productRepo.zget(score);
	}
	
	@RequestMapping(value = "/zrange", method = RequestMethod.GET)
	public Set zrange(@RequestParam(value="min") int min, @RequestParam(value="max") int max ) {
		 
			
			return productRepo.zrange(min,max);
	}
	
	@RequestMapping(value = "/zrangescore", method = RequestMethod.GET)
	public Set zrangescore(@RequestParam(value="min") int min, @RequestParam(value="max") int max ) {
		 
			
			return productRepo.zrangescore(min,max);
	}
	
}