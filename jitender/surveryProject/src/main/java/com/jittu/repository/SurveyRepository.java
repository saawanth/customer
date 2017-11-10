package com.jittu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jittu.model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

}
