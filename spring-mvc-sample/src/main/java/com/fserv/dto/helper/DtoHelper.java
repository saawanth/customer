package com.fserv.dto.helper;

public interface DtoHelper<D, M> {

  public M dtoToModel(D dto);

  public D modelToDto(M model);

}
  