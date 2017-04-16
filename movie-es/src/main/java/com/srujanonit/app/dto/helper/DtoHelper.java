package com.srujanonit.app.dto.helper;

public interface DtoHelper<D, M> {
	
	  public M dtoToModel(D dto);

	  public D modelToDto(M model);
}
