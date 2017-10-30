package com.nic.service;

import java.util.List;

import com.nic.dto.IDto;
import com.nic.model.IEntity;

public interface IService<D extends IDto, T extends IEntity> {

  public List<D> findAll();

  D findOne(final long id);

  public D create(final D resourceDto);

  public D update(final D resourceDto);

  void delete(final long id);

  void deleteAll();

  long count();
}
