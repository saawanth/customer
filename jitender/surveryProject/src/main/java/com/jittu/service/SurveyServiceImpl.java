package com.jittu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jittu.model.Survey;
import com.jittu.repository.SurveyRepository;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;

	

	@Override
	public List<Survey> findAll() {
		List<Survey> surveyList = surveyRepository.findAll();
		return surveyList;
	}


	@Override
	public Survey findOne(int id) {
		Survey survey = surveyRepository.getOne(id);
		return survey;
	}

}
