package com.manohar.DtoHelper;

import com.manohar.dto.QuestionChoiceDto;
import com.manohar.model.QuestionChoice;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionChoiceDtoHelper implements DtoHelper<QuestionChoice,QuestionChoiceDto>{
    private static final Logger LOGGER = Logger.getLogger(QuestionChoiceDtoHelper.class);
    @Override
    public List<QuestionChoiceDto> buildDto(Iterable<QuestionChoice> models) {

        return null;
    }

    @Override
    public QuestionChoiceDto buildDto(QuestionChoice questionChoice) {
        QuestionChoiceDto questionChoiceDto = new QuestionChoiceDto();
        questionChoiceDto.setId(questionChoice.getId());
        questionChoiceDto.setChoice(questionChoice.getChoice());
        return questionChoiceDto;
    }

    @Override
    public QuestionChoice build(QuestionChoiceDto questionChoiceDto) {
        QuestionChoice questionChoice = new QuestionChoice();
        questionChoice.setId(questionChoiceDto.getId());
        questionChoice.setChoice(questionChoiceDto.getChoice());

        return questionChoice;
    }

    @Override
    public List<QuestionChoice> build(Iterable<QuestionChoiceDto> dtos) {        // TODO Auto-generated method stub
        return null;
    }


}