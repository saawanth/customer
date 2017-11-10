package com.jittu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jittu.model.Question;

public interface QuestionService {
	public List<Question> findAll();
	 
	public Question findOne(int id);

}
