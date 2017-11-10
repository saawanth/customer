package com.arun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.dto.SurveyDto;
import com.arun.dtoHelper.SurveyDtoHelper;
import com.arun.model.Survey;
import com.arun.repository.SurveyRepository;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private SurveyDtoHelper surveyDtoHelper;
	

	@Override
	public List<SurveyDto> findAll() {
		List<Survey> surveyList = surveyRepository.findAll();
		if(!(null == surveyList)) {
			List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();
			for(Survey survey :surveyList) {
				surveyDtoList.add(surveyDtoHelper.buildDto(survey));
			}return surveyDtoList;
		}else
		return null;
	}


	@Override
	public SurveyDto findOne(int id) {
//		Survey survey = surveyRepository.findAllById(id);
		return null;
	}

}
