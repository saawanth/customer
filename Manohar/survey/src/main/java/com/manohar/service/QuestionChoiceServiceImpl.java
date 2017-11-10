package com.manohar.service;

import com.manohar.model.QuestionChoice;
import com.manohar.repository.QuestionChoiceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionChoiceServiceImpl implements QuestionChoiceService {
    private static final Logger LOGGER = Logger.getLogger(QuestionChoiceServiceImpl.class);
    @Autowired
    private QuestionChoiceRepository questionChoiceRepository;


    @Override
    public List<QuestionChoice> findAll() {
        List<QuestionChoice> questionChoiceList = questionChoiceRepository.findAll();
        return questionChoiceList;
    }

    @Override
    @Transactional(readOnly = true)
    public QuestionChoice findOne(int id) {
        QuestionChoice questionChoice = questionChoiceRepository.findOne(id);
        return questionChoice;
    }

}
