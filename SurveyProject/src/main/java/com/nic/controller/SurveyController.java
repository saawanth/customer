package com.nic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nic.dto.SurveyDto;
import com.nic.model.Survey;
import com.nic.service.IService;
import com.nic.service.SurveyService;

@RestController
@RequestMapping("/surveys")
public class SurveyController extends AbstractController<SurveyDto, Survey> {

  @Autowired
  SurveyService surveyService;

  @Autowired
  public SurveyController() {
    super(SurveyDto.class);
  }

  @Override
  protected IService<SurveyDto, Survey> getService() {
    return surveyService;
  }

}
