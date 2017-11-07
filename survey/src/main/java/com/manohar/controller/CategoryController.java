package com.manohar.controller;

import java.util.List;

import com.manohar.dto.CategoryDto;
import com.manohar.model.Category;
import com.manohar.repository.CategoryRepositoy;
import com.manohar.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoryService categoryService;


	@GetMapping(value = "/list", produces = "application/json")
	public @ResponseBody
	ResponseEntity<List<CategoryDto>> findAll() {
		List<CategoryDto> categoryDtoList = categoryService.findAll();
		if (null == categoryDtoList)
			return new ResponseEntity<List<CategoryDto>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<CategoryDto>>(categoryDtoList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",produces = "application/json")
	public @ResponseBody
	ResponseEntity<CategoryDto> findOne(
			@PathVariable(value = "id") int id) {
		CategoryDto categoryDto = categoryService.findOne(id);
		if (null == categoryDto)
			return new ResponseEntity<CategoryDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

	}

}
