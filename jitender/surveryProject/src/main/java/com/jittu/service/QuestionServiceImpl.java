package com.jittu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jittu.model.Question;
import com.jittu.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public List<Question> findAll() {
		List<Question> questionList = questionRepository.findAll();
		return questionList;
	}

	@Override
	public Question findOne(int id) {
		Question question = questionRepository.getOne(id);
		return question;
	}

}
