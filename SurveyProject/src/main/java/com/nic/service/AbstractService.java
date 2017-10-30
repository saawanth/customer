package com.nic.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.nic.dto.IDto;
import com.nic.model.IEntity;
import com.nic.web.ServicePreconditions;

@Transactional
public abstract class AbstractService<D extends IDto, T extends IEntity> implements IService<D, T> {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  ModelMapper modelMapper;

  private Class<T> clazz;
  private Class<D> dtoClazz;

  public AbstractService(final Class<T> clazzToSet, final Class<D> dtoClazzToSet) {
    super();
    this.clazz = clazzToSet;
    this.dtoClazz = dtoClazzToSet;
  }

  // find - one
  @Override
  @Transactional(readOnly = true)
  public D findOne(final long id) {
    T entity = getDao().findOne(id);
    return modelMapper.map(entity, dtoClazz);
  }

  // find - all
  @Override
  @Transactional(readOnly = true)
  public List<D> findAll() {
    Iterable<T> resources = getDao().findAll();
    return newArrayList(resources);
  }

  @Override
  public D create(final D dto) {
    Preconditions.checkNotNull(dto);
    T entity = modelMapper.map(dto, clazz);
    entity = getDao().save(entity);

    return modelMapper.map(entity, dtoClazz);
  }

  // update/merge

  @Override
  public D update(final D dto) {
    Preconditions.checkNotNull(dto);
    T entity = modelMapper.map(dto, clazz);
    entity = getDao().save(entity);

    return modelMapper.map(entity, dtoClazz);
  }

  // delete

  @Override
  public void deleteAll() {
    getDao().deleteAll();
  }

  @Override
  public void delete(final long id) {
    final T entity = getDao().findOne(id);
    ServicePreconditions.checkEntityExists(entity);

    getDao().delete(entity);
  }

  // count
  @Override
  public long count() {
    return getDao().count();
  }

  // template method
  protected abstract PagingAndSortingRepository<T, Long> getDao();

  public List<D> newArrayList(Iterable<T> elements) {
    Preconditions.checkNotNull(elements);
    List<D> dtos = new ArrayList<>();
    for (T model : elements) {
      dtos.add(modelMapper.map(model, dtoClazz));
    }
    return dtos;
  }
}
