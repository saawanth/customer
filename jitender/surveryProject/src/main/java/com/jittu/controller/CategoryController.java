package com.jittu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jittu.dto.CategoryDto;
import com.jittu.model.Category;
import com.jittu.repository.CategoryRepository;
import com.jittu.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/list", produces = "application/json")
	public @ResponseBody ResponseEntity<List<CategoryDto>> findAll(){
		List<CategoryDto> categoryDtoList = categoryService.findAll();
		
		return null;
	}

}
