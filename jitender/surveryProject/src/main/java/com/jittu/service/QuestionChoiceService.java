package com.jittu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jittu.model.QuestionChoice;


public interface QuestionChoiceService {

	public List<QuestionChoice> findAll();
	 
	public QuestionChoice findOne(int id);
}
