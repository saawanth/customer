package org.movie.store.dto.helper;

import java.util.List;

public interface DtoHelper<M, D> {
  public List<D> buildDto(Iterable<M> models);

  public D buildDto(M model);

  public M build(D dto);

  public List<M> build(Iterable<D> dtos);
}
