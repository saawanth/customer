package com.redis.repo;

import java.util.Map;

import com.redis.model.Product;

public interface ProductRepository {
	void saveProduct(Product product);

	Product find(String name);
}
