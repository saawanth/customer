package com.myretail.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<ID extends Serializable, D> {

	List<D> findAll();

	List<D> findAll(Iterable<ID> ids);

	List<D> save(Iterable<D> entities);

	D findOne(ID id);

	D save(D entity);

}
