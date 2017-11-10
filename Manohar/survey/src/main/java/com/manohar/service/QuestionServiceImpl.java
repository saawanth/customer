package com.manohar.service;

import com.manohar.model.Question;
import com.manohar.repository.QuestionRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
    private static final Logger LOGGER = Logger.getLogger(QuestionServiceImpl.class);
    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public List<Question> findAll() {
        List<Question> questionList = questionRepository.findAll();
        return questionList;
    }

    @Override
    @Transactional(readOnly = true)
    public Question findOne(int id) {
        Question question = questionRepository.findOne(id);
        return question;
    }

}
