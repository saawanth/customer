package com.redis.repo;

import java.util.Map;

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


}

