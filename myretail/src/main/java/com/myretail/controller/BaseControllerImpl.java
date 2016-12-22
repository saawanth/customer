package com.myretail.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myretail.service.BaseService;

public abstract class BaseControllerImpl<ID extends Serializable, D> implements BaseController<ID, D> {

	protected BaseService<ID, D> resourceService;

	@Autowired
	public BaseControllerImpl(BaseService<ID, D> baseService) {
		super();
		this.resourceService = baseService;
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<D> findOne(@PathVariable ID id) {
		D dt = resourceService.findOne(id);
		return new ResponseEntity<D>(dt, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<D>> findAll() {
		List<D> dtoList = resourceService.findAll();
		return new ResponseEntity<List<D>>(dtoList, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<D> add(@RequestBody D dto) {
		D dt = resourceService.save(dto);
		return new ResponseEntity<D>(dt, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<D> update(@RequestBody D dto) {
		D updatedResource = resourceService.save(dto);
		return new ResponseEntity<D>(updatedResource, HttpStatus.OK);
	}

}
