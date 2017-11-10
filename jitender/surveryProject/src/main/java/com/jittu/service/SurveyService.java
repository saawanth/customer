package com.jittu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jittu.dto.SurveyDto;
import com.jittu.model.Survey;


public interface SurveyService {
	
	public List<Survey> findAll();

	public Survey findOne(int id);

}
