package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myretail.model.Product;

@Repository
@Transactional
public interface ProductRepository extends MongoRepository<Product, Long> {
	
}
