package com.arun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arun.dto.CategoryDto;

@Service
public interface CategoryService {
	public List<CategoryDto> findAll();

}
