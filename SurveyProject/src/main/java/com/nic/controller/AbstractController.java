package com.nic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Preconditions;
import com.nic.dto.IDto;
import com.nic.model.IEntity;
import com.nic.service.IService;
import com.nic.web.RestPreconditions;
import com.nic.web.exception.MyResourceNotFoundException;

public abstract class AbstractController<D extends IDto, E extends IEntity> {

  protected Class<D> clazz;

  @Autowired
  public AbstractController(final Class<D> clazzToSet) {
    super();
    Preconditions.checkNotNull(clazzToSet);
    clazz = clazzToSet;
  }

  // save/create/persist

  protected final D createInternal(final D resource, final UriComponentsBuilder uriBuilder,
      final HttpServletResponse response) {
    RestPreconditions.checkRequestElementNotNull(resource);
    final D existingResource = getService().create(resource);
    return existingResource;
  }

  // update

  /**
   * - note: the operation is IDEMPOTENT <br/>
   */
  protected final D updateInternal(final long id, final D resource) {
    RestPreconditions.checkRequestElementNotNull(resource);
    RestPreconditions.checkRequestElementNotNull(resource.getId());
    RestPreconditions.checkNotNull(getService().findOne(resource.getId()));

    return getService().update(resource);
  }

  // delete/remove

  protected final void deleteByIdInternal(final long id) {
    // InvalidDataAccessApiUsageException - ResourceNotFoundException
    // IllegalStateException - ResourceNotFoundException
    // DataAccessException - ignored
    getService().delete(id);
  }

  // find - one
  protected final D findOneInternal(final Long id) {
    return RestPreconditions.checkNotNull(getService().findOne(id));
  }

  // find - all

  protected final List<D> findAllInternal(final HttpServletRequest request) {
    if (request.getParameterNames().hasMoreElements()) {
      throw new MyResourceNotFoundException();
    }

    return getService().findAll();
  }

  // template method

  protected abstract IService<D, E> getService();

}
