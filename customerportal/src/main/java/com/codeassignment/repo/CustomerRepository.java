package com.codeassignment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeassignment.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {


}
