package org.movie.store.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface BaseController<ID extends Serializable, D> {

	ResponseEntity<D> add(D dto);

	ResponseEntity<D> update(D dto);

	ResponseEntity<D> findOne(ID id);

	ResponseEntity<D> delete(ID id);

	ResponseEntity<List<D>> findAll();
}
