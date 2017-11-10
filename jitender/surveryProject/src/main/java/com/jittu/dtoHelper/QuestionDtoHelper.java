package com.jittu.dtoHelper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jittu.dto.QuestionChoiceDto;
import com.jittu.dto.QuestionDto;
import com.jittu.model.Question;
import com.jittu.model.QuestionChoice;

@Component
public class QuestionDtoHelper implements DtoHelper<Question, QuestionDto> {
	
	@Autowired
	QuestionChoiceDtoHelper questionChoiceDtoHelper;

	@Override
	public List<QuestionDto> buildDto(Iterable<Question> models) {

		return null;
	}

	@Override
	public QuestionDto buildDto(Question question) {
		// TODO Auto-generated method stub
		QuestionDto questionDto = new QuestionDto();
		questionDto.setId(question.getId());
		questionDto.setParent_id(question.getParent_id());
		questionDto.setQuestion_name(question.getQuestion_name());
		questionDto.setQuestion_type(question.getQuestion_type());

		List<QuestionChoice> questionChoiceList = question.getAnswers();
		List<QuestionChoiceDto> questionChoiceDtoList = new ArrayList<QuestionChoiceDto>();
		for(QuestionChoice queChoice : questionChoiceList) {
			questionChoiceDtoList.add(questionChoiceDtoHelper.buildDto(queChoice));
		}
		questionDto.setQuestionChoices(questionChoiceDtoList);
		return questionDto;
	}

	@Override
	public Question build(QuestionDto questionDto) {
		Question question = new Question();
		question.setId(questionDto.getId());
		question.setParent_id(questionDto.getParent_id());
		question.setQuestion_name(questionDto.getQuestion_name());
		question.setQuestion_type(questionDto.getQuestion_type());
		return null;
	}

	@Override
	public List<Question> build(Iterable<QuestionDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
