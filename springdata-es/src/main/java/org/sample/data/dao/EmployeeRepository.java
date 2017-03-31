package org.sample.data.dao;

import org.sample.data.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository < Employee, Long >{

}
