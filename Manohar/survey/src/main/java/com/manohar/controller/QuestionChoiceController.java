package com.manohar.controller;

import com.manohar.DtoHelper.QuestionChoiceDtoHelper;
import com.manohar.dto.QuestionChoiceDto;
import com.manohar.model.QuestionChoice;
import com.manohar.service.QuestionChoiceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questionChoice")
public class QuestionChoiceController {
    private static final Logger LOGGER = Logger.getLogger(QuestionChoiceController.class);
    @Autowired
    private QuestionChoiceService questionChoiceService;

    @Autowired
    private QuestionChoiceDtoHelper questionChoiceDtoHelper;


    @GetMapping(value = "/list", produces = "application/json")
    public @ResponseBody
    ResponseEntity<List<QuestionChoiceDto>> findAll() {
        List<QuestionChoice> questionChoiceList = questionChoiceService.findAll();
        List<QuestionChoiceDto> questionChoiceDtoList = new ArrayList<>();
        if(null != questionChoiceList) {
            for (QuestionChoice questionChoice : questionChoiceList) {
                questionChoiceDtoList.add(questionChoiceDtoHelper.buildDto(questionChoice));
            }
        }
        if (null == questionChoiceDtoList)
            return new ResponseEntity<List<QuestionChoiceDto>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<QuestionChoiceDto>>(questionChoiceDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",produces = "application/json")
    public @ResponseBody
    ResponseEntity<QuestionChoiceDto> findOne(
            @PathVariable(value = "id") int id) {
        QuestionChoice questionChoice = questionChoiceService.findOne(id);
        QuestionChoiceDto questionChoiceDto = new QuestionChoiceDto();
        if (!(null == questionChoice)) {
            questionChoiceDto = questionChoiceDtoHelper.buildDto(questionChoice);
        }
        if (null == questionChoice)
            return new ResponseEntity<QuestionChoiceDto>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<QuestionChoiceDto>(questionChoiceDto, HttpStatus.OK);

    }

}
