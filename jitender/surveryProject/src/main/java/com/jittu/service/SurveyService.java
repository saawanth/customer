package com.jittu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jittu.dto.SurveyDto;


public interface SurveyService {
	
	public List<SurveyDto> findAll();

	public SurveyDto findOne(int id);

}
