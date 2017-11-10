package com.manohar.controller;

import com.manohar.DtoHelper.QuestionDtoHelper;
import com.manohar.dto.QuestionDto;
import com.manohar.model.Question;
import com.manohar.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private static final Logger LOGGER = Logger.getLogger(QuestionController.class);
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionDtoHelper questionDtoHelper;


    @GetMapping(value = "/list", produces = "application/json")
    public @ResponseBody
    ResponseEntity<List<QuestionDto>> findAll() {
        List<Question> questionList = questionService.findAll();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        if(null != questionList) {
            for (Question question : questionList) {
                questionDtoList.add(questionDtoHelper.buildDto(question));
            }
        }
        if (null == questionDtoList)
            return new ResponseEntity<List<QuestionDto>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<QuestionDto>>(questionDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",produces = "application/json")
    public @ResponseBody
    ResponseEntity<QuestionDto> findOne(
            @PathVariable(value = "id") int id) {
        Question question = questionService.findOne(id);
        QuestionDto questionDto = new QuestionDto();
        if (!(null == question)) {
           questionDto = questionDtoHelper.buildDto(question);
        }
        if (null == questionDto)
            return new ResponseEntity<QuestionDto>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<QuestionDto>(questionDto, HttpStatus.OK);

    }


}
