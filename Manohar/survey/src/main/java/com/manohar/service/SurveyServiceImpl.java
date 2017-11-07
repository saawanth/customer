package com.manohar.service;

import java.util.ArrayList;
import java.util.List;

import com.manohar.DtoHelper.SurveyDtoHelper;
import com.manohar.dto.SurveyDto;
import com.manohar.model.Survey;
import com.manohar.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyRepository surveyRespositiry;
	
	@Autowired
	private SurveyDtoHelper surveyDtoHelper;
	

	@Override
	public List<SurveyDto> findAll() {
		List<Survey> surveyList = surveyRespositiry.findAll();
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
		Survey survey = surveyRespositiry.findOne(id);
		if (!(null == survey)) {
			SurveyDto surveyDto = surveyDtoHelper.buildDto(survey);
			return surveyDto;
		} else
			return null;
	}

}
