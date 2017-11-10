package com.jittu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jittu.model.Question;
import com.jittu.model.QuestionChoice;
import com.jittu.repository.QuestionChoiceRepository;

@Service
public class QuestionChoiceServiceImpl implements QuestionChoiceService{
	
	@Autowired
	private QuestionChoiceRepository questionChoiceRepository;

	@Override
	public List<QuestionChoice> findAll() {
		List<QuestionChoice> questionChoiceList = questionChoiceRepository.findAll();
		return questionChoiceList;
	}

	@Override
	public QuestionChoice findOne(int id) {
		QuestionChoice questionChoice = questionChoiceRepository.getOne(id);
		return questionChoice;
	}

	

}
