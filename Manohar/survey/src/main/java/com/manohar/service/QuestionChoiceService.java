package com.manohar.service;

import com.manohar.model.QuestionChoice;

import java.util.List;

public interface QuestionChoiceService {
    public List<QuestionChoice> findAll();
    public QuestionChoice findOne(int id);
}
