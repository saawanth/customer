package com.manohar.service;

import com.manohar.model.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> findAll();
    public Question findOne(int id);
}
