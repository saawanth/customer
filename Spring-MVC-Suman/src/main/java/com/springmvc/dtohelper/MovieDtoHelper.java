package com.springmvc.dtohelper;

public interface MovieDtoHelper<M , D> {

	 public M dtoToModel(D dto);

	  public D modelToDto(M model);
	  
}
