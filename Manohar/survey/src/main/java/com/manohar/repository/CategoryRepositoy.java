package com.manohar.repository;

import com.manohar.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoy extends JpaRepository<Category, Integer>{
}
