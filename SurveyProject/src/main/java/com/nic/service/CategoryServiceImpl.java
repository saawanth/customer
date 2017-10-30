package com.nic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.dto.CategoryDto;
import com.nic.model.Category;
import com.nic.repository.CategoryRepository;

@Service
public class CategoryServiceImpl extends AbstractService<CategoryDto, Category>
    implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepo;

  public CategoryServiceImpl() {
    super(Category.class, CategoryDto.class);
  }

  @Override
  protected CategoryRepository getDao() {
    return categoryRepo;
  }

}
