package com.springmvc.dtohelper;

public interface DtoHelper<M, D> {


	  public M dtoToModel(D dto);

	  public D modelToDto(M model);
	  
	  
}
