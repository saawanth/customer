package com.manohar.DtoHelper;

import com.manohar.dto.QuestionChoiceDto;
import com.manohar.dto.QuestionDto;
import com.manohar.model.Question;
import com.manohar.model.QuestionChoice;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class QuestionDtoHelper implements DtoHelper<Question, QuestionDto> {
    private static final Logger LOGGER = Logger.getLogger(QuestionDtoHelper.class);
    @Autowired
    QuestionChoiceDtoHelper questionChoiceDtoHelper;

    @Override
    public List<QuestionDto> buildDto(Iterable<Question> models) {

        return null;
    }

    @Override
    public QuestionDto buildDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setQuestion(question.getQuestion());
        questionDto.setQuestionGroup(question.getQuestionGroup());
        questionDto.setQuestionType(question.getQuestionType());
        List<QuestionChoice> questionChoiceList = question.getQuestionChoiceList();
        List<QuestionChoiceDto> questionChoiceDtoList = new ArrayList<>();
        for(QuestionChoice questionChoice: questionChoiceList) {
            questionChoiceDtoList.add(questionChoiceDtoHelper.buildDto(questionChoice));
        }
        questionDto.setQuestionChoice(questionChoiceDtoList);

        return questionDto;
    }

    @Override
    public Question build(QuestionDto questionDto) {
        Question question = new Question();
        question.setId(questionDto.getId());
        question.setQuestion(questionDto.getQuestion());
        question.setQuestionGroup(questionDto.getQuestionGroup());
        question.setQuestionType(questionDto.getQuestionType());
        return question;
    }

    @Override
    public List<Question> build(Iterable<QuestionDto> dtos) {		// TODO Auto-generated method stub
        return null;
    }


}
