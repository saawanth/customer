package com.manohar.controller;

import java.util.List;

import com.manohar.dto.SurveyDto;
import com.manohar.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;


    @GetMapping(value = "/list", produces = "application/json")
    public @ResponseBody
    ResponseEntity<List<SurveyDto>> findAll() {
        List<SurveyDto> surveyDtoList = surveyService.findAll();
        if (null == surveyDtoList)
            return new ResponseEntity<List<SurveyDto>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<SurveyDto>>(surveyDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",produces = "application/json")
    public @ResponseBody
    ResponseEntity<SurveyDto> findOne(
            @PathVariable(value = "id") int id) {
        SurveyDto surveyDto = surveyService.findOne(id);
        if (null == surveyDto)
            return new ResponseEntity<SurveyDto>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<SurveyDto>(surveyDto, HttpStatus.OK);

    }

}
