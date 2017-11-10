package com.manohar.controller;

import com.manohar.DtoHelper.CategoryDtoHelper;
import com.manohar.dto.CategoryDto;
import com.manohar.model.Category;
import com.manohar.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryDtoHelper categoryDtoHelper;


	@GetMapping(value = "/list", produces = "application/json")
	public @ResponseBody
	ResponseEntity<List<CategoryDto>> findAll() {
		List<Category> categoryList = categoryService.findAll();
		List<CategoryDto> categoryDtoList = new ArrayList<>();
		if(null != categoryList) {
			for (Category category : categoryList) {
				categoryDtoList.add(categoryDtoHelper.buildDto(category));
			}
		}
		if (null == categoryDtoList)
			return new ResponseEntity<List<CategoryDto>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<CategoryDto>>(categoryDtoList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",produces = "application/json")
	public @ResponseBody
	ResponseEntity<CategoryDto> findOne(
			@PathVariable(value = "id") int id) {
		Category category = categoryService.findOne(id);
		CategoryDto categoryDto = new CategoryDto();
		if (!(null == category)) {
			categoryDto = categoryDtoHelper.buildDto(category);
		}
		if (null == categoryDto)
			return new ResponseEntity<CategoryDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

	}


}
