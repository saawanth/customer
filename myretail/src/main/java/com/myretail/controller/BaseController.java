package com.myretail.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface BaseController<ID extends Serializable, D> {

	ResponseEntity<D> add(D dto);

	ResponseEntity<D> update(D dto);

	ResponseEntity<D> findOne(ID id);

	ResponseEntity<List<D>> findAll();
}
