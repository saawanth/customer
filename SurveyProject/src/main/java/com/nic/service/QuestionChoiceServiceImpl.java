package com.nic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.dto.QuestionChoiceDto;
import com.nic.model.QuestionChoice;
import com.nic.repository.QuestionChoiceRepository;

@Service
public class QuestionChoiceServiceImpl extends AbstractService<QuestionChoiceDto, QuestionChoice>
    implements QuestionChoiceService {

  @Autowired
  private QuestionChoiceRepository questionChoiceRepo;

  public QuestionChoiceServiceImpl() {
    super(QuestionChoice.class, QuestionChoiceDto.class);
  }

  @Override
  protected QuestionChoiceRepository getDao() {
    return questionChoiceRepo;
  }

}
