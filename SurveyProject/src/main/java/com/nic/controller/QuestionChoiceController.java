package com.nic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nic.dto.QuestionChoiceDto;
import com.nic.model.QuestionChoice;
import com.nic.service.IService;
import com.nic.service.QuestionChoiceService;

@RestController
@RequestMapping("/questionChoices")
public class QuestionChoiceController
    extends AbstractController<QuestionChoiceDto, QuestionChoice> {

  @Autowired
  QuestionChoiceService questionChoiceService;

  @Autowired
  public QuestionChoiceController() {
    super(QuestionChoiceDto.class);
  }

  @Override
  protected IService<QuestionChoiceDto, QuestionChoice> getService() {
    return questionChoiceService;
  }

}
