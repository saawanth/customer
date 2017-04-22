package com.redis.repo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  private static final String KEY = "Product";
  private final RedisTemplate<String, Product> redisTemplate;
  private HashOperations hashOps;

  @Autowired
  private ProductRepositoryImpl(RedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @PostConstruct
  private void init() {
    hashOps = redisTemplate.opsForHash();
  }

  @Override
  public void saveProduct(Product product) {
    hashOps.put(KEY, product.getName(), product);
  }

@Override
public Product find(String name) {
	return (Product) redisTemplate.opsForHash().get(KEY,name);
	
}

@Override
public List<Object> findAll() {
	
Set<Object> hashKeys=hashOps.keys(KEY);
	
	return hashOps.multiGet(KEY, hashKeys);
}

@Override
public Set<Object> findKeySet() {
	Set<Object> keyset=hashOps.keys(KEY);
	return keyset;
}

@Override
public Map allEntries() {
	Map entrySet=hashOps.entries(KEY);
	return entrySet;
}

@Override
public boolean hasKey(String hashKey) {
	boolean bool=hashOps.hasKey(KEY, hashKey);
	return bool;
}

@Override
public long findSize() {
	long size=hashOps.size(KEY);
	return size;
}

@Override
public List<Product> findValues() {
	List<Product> values=hashOps.values(KEY);
	return values;
}

@Override
public void remove(String name) {
	hashOps.delete(KEY, name);
	
}

}

