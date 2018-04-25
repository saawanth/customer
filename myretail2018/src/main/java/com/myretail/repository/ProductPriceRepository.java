package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myretail.model.ProductPrice;

@Repository
@Transactional
public interface ProductPriceRepository extends MongoRepository<ProductPrice, Long> {

}