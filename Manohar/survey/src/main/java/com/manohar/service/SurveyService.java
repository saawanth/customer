package com.manohar.service;

import com.manohar.model.Survey;

import java.util.List;

public interface SurveyService {
	
	public List<Survey> findAll();
	public Survey findOne(int id);

}
