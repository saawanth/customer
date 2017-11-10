package com.jittu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jittu.dto.CategoryDto;
import com.jittu.dtoHelper.CategoryDtoHelper;
import com.jittu.model.Category;
import com.jittu.repository.CategoryRepository;
import com.jittu.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryDtoHelper categoryDtoHelper;
	
	@GetMapping(value = "/list", produces = "application/json")
	public @ResponseBody ResponseEntity<List<CategoryDto>> findAll(){
		List<Category> categoryList = categoryService.findAll();
		List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
		if(null != categoryList) {
			for (Category category : categoryList) {
				categoryDtoList.add(categoryDtoHelper.buildDto(category));
			}
		}
//		if (null == categoryDtoList)
//			return new ResponseEntity<List<CategoryDto>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<CategoryDto>>(categoryDtoList, HttpStatus.OK);
	
	}
	
	@GetMapping(value = "/{id}",produces = "application/json")
	public @ResponseBody
	ResponseEntity<CategoryDto> findOne(@PathVariable(value = "id") int id) {
		Category category = categoryService.findOne(id);
		CategoryDto categoryDto = new CategoryDto();
		if (null != category) {
			categoryDto = categoryDtoHelper.buildDto(category);
		}
		if (null == categoryDto)
			return new ResponseEntity<CategoryDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

	}

}
