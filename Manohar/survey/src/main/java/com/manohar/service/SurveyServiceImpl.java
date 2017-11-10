package com.manohar.service;

import com.manohar.model.Survey;
import com.manohar.repository.SurveyRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {

 	private static final Logger LOGGER = Logger.getLogger(SurveyServiceImpl.class);
	@Autowired
	private SurveyRepository surveyRespositiry;

	@Override
	public List<Survey> findAll() {
		List<Survey> surveyList = surveyRespositiry.findAll();
		return surveyList;
	}

	@Override
	@Transactional(readOnly = true)
	public Survey findOne(int id) {
		Survey survey = surveyRespositiry.findOne(id);
		return survey;
	}

}
