package com.jittu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jittu.dto.QuestionChoiceDto;
import com.jittu.dtoHelper.QuestionChoiceDtoHelper;
import com.jittu.model.QuestionChoice;
import com.jittu.service.QuestionChoiceService;

@RestController
@RequestMapping("/questionchoice")
public class QuestionChoiceController {
	
	@Autowired
	private QuestionChoiceService questionChoiceService;
	
	@Autowired
	private QuestionChoiceDtoHelper questionChoiceDtoHelper;
	
	@GetMapping(value = "/list", produces = "application/json")
	public @ResponseBody ResponseEntity<List<QuestionChoiceDto>> findAll(){
		List<QuestionChoice> questionChoiceList = questionChoiceService.findAll();
		List<QuestionChoiceDto> questionChoiceDtoList = new ArrayList<QuestionChoiceDto>();
		if(null != questionChoiceList) {
			for(QuestionChoice questionChoice : questionChoiceList){
				questionChoiceDtoList.add(questionChoiceDtoHelper.buildDto(questionChoice));
			}
		}
		
		return new ResponseEntity<List<QuestionChoiceDto>>(questionChoiceDtoList, HttpStatus.OK);
		
	}

}
