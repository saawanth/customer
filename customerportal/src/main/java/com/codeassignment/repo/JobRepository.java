package com.codeassignment.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeassignment.model.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

	@Query("Select j from Job j where j.dueDate BETWEEN :fromDate AND :toDate")
	List<Job> findJobsByDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query("Select j from Job j where j.customer.id=:customerId")
	List<Job> findAllCustomerJobs(@Param("customerId") Long customerId);

}
