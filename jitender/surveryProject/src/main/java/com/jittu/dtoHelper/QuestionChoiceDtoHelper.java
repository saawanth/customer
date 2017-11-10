package com.jittu.dtoHelper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jittu.dto.QuestionChoiceDto;
import com.jittu.model.QuestionChoice;

@Component
public class QuestionChoiceDtoHelper implements DtoHelper<QuestionChoice, QuestionChoiceDto> {

	@Override
	public List<QuestionChoiceDto> buildDto(Iterable<QuestionChoice> models) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionChoiceDto buildDto(QuestionChoice model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionChoice build(QuestionChoiceDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionChoice> build(Iterable<QuestionChoiceDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
