package com.jittu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jittu.dto.SurveyDto;
import com.jittu.dtoHelper.SurveyDtoHelper;
import com.jittu.model.Survey;
import com.jittu.repository.SurveyRepository;

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
		Survey survey = surveyRepository.getOne(id);
		if(!(null == survey)) {
			SurveyDto dto = surveyDtoHelper.buildDto(survey);
			return dto;
		}else
		return null;
	}

}
