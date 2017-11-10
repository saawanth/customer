package com.arun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arun.dto.SurveyDto;

@Service
public interface SurveyService {
	
	public List<SurveyDto> findAll();

	public SurveyDto findOne(int id);

}
