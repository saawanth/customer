package com.nic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.dto.SurveyDto;
import com.nic.model.Survey;
import com.nic.repository.SurveyRepository;

@Service
public class SurveyServiceImpl extends AbstractService<SurveyDto, Survey> implements SurveyService {

  @Autowired
  private SurveyRepository surveyRepo;

  public SurveyServiceImpl() {
    super(Survey.class, SurveyDto.class);
  }

  @Override
  protected SurveyRepository getDao() {
    return surveyRepo;
  }
}
