package com.manohar.controller;

import java.util.ArrayList;
import java.util.List;

import com.manohar.DtoHelper.SurveyDtoHelper;
import com.manohar.dto.SurveyDto;
import com.manohar.model.Survey;
import com.manohar.service.SurveyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/survey")
public class SurveyController {
    private static final Logger LOGGER = Logger.getLogger(SurveyController.class);
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyDtoHelper surveyDtoHelper;


    @GetMapping(value = "/list", produces = "application/json")
    public @ResponseBody
    ResponseEntity<List<SurveyDto>> findAll() {
        List<Survey> surveyList = surveyService.findAll();
        List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();
        if(null != surveyList) {
            for (Survey survey : surveyList) {
                surveyDtoList.add(surveyDtoHelper.buildDto(survey));
            }
        }
        if (null == surveyDtoList)
            return new ResponseEntity<List<SurveyDto>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<SurveyDto>>(surveyDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",produces = "application/json")
    public @ResponseBody
    ResponseEntity<SurveyDto> findOne(
            @PathVariable(value = "id") int id) {
        Survey survey = surveyService.findOne(id);
        SurveyDto surveyDto = new SurveyDto();
        if (!(null == survey)) {
            surveyDto = surveyDtoHelper.buildDto(survey);
        }
        if (null == surveyDto)
            return new ResponseEntity<SurveyDto>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<SurveyDto>(surveyDto, HttpStatus.OK);

    }

}
