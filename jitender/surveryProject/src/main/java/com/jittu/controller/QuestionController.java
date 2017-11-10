package com.jittu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jittu.dto.QuestionDto;
import com.jittu.dtoHelper.QuestionDtoHelper;
import com.jittu.model.Question;

import com.jittu.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionDtoHelper questionDtoHelper;
	
	@GetMapping(value = "/list", produces = "application/json")
	public @ResponseBody ResponseEntity<List<QuestionDto>> findAll(){
		List<Question> questionList = questionService.findAll();
		List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();
		if(null != questionList) {
			for(Question question : questionList){
				questionDtoList.add(questionDtoHelper.buildDto(question));
			}
		}
		
		return new ResponseEntity<List<QuestionDto>>(questionDtoList, HttpStatus.OK);
 	}


}
