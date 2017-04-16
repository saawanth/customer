package com.srujanonit.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srujanonit.app.dao.model.Movie;
import com.srujanonit.app.dao.repo.MovieRepo;

@Service
@Transactional
public class MovieServiceImpl implements BaseService<Long, Movie>{

	@Autowired
	MovieRepo movieRepo;
	
	public List<Movie> findAll() {
		// TODO Auto-generated method stub

		return movieRepo.getAll();
	}

	public Movie find(Long id) {
		// TODO Auto-generated method stub
		return movieRepo.find(id);
	}

	public Movie save(Movie entity) {
		// TODO Auto-generated method stub
		return movieRepo.save(entity);
	}

	public Movie update(Movie entity) {
		// TODO Auto-generated method stub
		return movieRepo.update(entity);
	}

	public Movie delete(Long id) {
		// TODO Auto-generated method stub
		return movieRepo.delete(id);
	}

}
