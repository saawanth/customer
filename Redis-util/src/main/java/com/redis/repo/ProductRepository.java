package com.redis.repo;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.redis.model.Product;

public interface ProductRepository {
	void saveProduct(Product product);

	Product find(String name);

	List<Object> findAll();

	Set<Object> findKeySet();

	Map allEntries();

	boolean hasKey(String hashKey);

	long findSize();

	List<Product> findValues();

	void remove(String name);
}
