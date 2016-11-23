package org.movie.store.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<ID extends Serializable, D> {

  List<D> findAll();

  List<D> findAll(Iterable<ID> ids);

  List<D> save(Iterable<D> entities);

  D getOne(ID id);

  D save(D entity);

  D delete(D dtoToDelete);

  D delete(ID id);

  D update(D entity);



}
