package com.sample.test.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.test.dto.helper.DtoHelper;
import com.sample.test.repository.BaseRepository;

public class BaseServiceImpl<T, ID extends Serializable, D> implements BaseService<ID, D> {

	protected BaseRepository<T, ID> repository;

	@Autowired(required = false)
	protected DtoHelper<T, D> dtoHelper;

	public BaseServiceImpl(BaseRepository<T, ID> repository, DtoHelper<T, D> dtoHelper) {
		super();
		this.repository = repository;
		this.dtoHelper = dtoHelper;
	}

	@Override
	public List<D> findAll() {
		Iterable<T> models = repository.findAll();
		return dtoHelper.buildDto(models);
	}

	@Override
	public List<D> findAll(Iterable<ID> ids) {
		Iterable<T> models = repository.findAll(ids);
		return dtoHelper.buildDto(models);
	}

	@Override
	public List<D> save(Iterable<D> dtos) {
		Iterable<T> modelsToSave = dtoHelper.build(dtos);
		List<D> savedDtos = dtoHelper.buildDto(repository.save(modelsToSave));
		return savedDtos;
	}

	@Override
	public D getOne(ID id) {
		T model = repository.getOne(id);
		return dtoHelper.buildDto(model);
	}

	@Override
	public D save(D dtoToInsert) {
		T modelToInsert = dtoHelper.build(dtoToInsert);
		T savedModel = repository.save(modelToInsert);
		return dtoHelper.buildDto(savedModel);
	}

	@Override
	public D delete(D dtoToDelete) {
		T modelToDelete = dtoHelper.build(dtoToDelete);
		repository.delete(modelToDelete);
		return null;

	}

	@Override
	public D delete(ID id) {
		T model = repository.getOne(id);
		D dt = dtoHelper.buildDto(model);
		repository.delete(model);

		return dt;
	}

	@Override
	public D update(D entity) {
		T model = dtoHelper.build(entity);
		T dt = repository.saveAndFlush(model);
		D dt1 = dtoHelper.buildDto(dt);
		return dt1;
	}

}
