package com.jittu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jittu.model.QuestionChoice;

@Repository
public interface QuestionChoiceRepository extends JpaRepository<QuestionChoice, Integer> {

}
