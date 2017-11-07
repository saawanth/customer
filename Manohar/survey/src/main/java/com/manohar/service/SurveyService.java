package com.manohar.service;

import java.util.List;

import com.manohar.dto.SurveyDto;

public interface SurveyService {
	
	public List<SurveyDto> findAll();
	public SurveyDto findOne(int id);

}
