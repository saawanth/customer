package com.nic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nic.dto.QuestionDto;
import com.nic.model.Question;
import com.nic.service.IService;
import com.nic.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController extends AbstractController<QuestionDto, Question> {

  @Autowired
  QuestionService questionService;

  @Autowired
  public QuestionController() {
    super(QuestionDto.class);
  }

  @Override
  protected IService<QuestionDto, Question> getService() {
    return questionService;
  }

}
