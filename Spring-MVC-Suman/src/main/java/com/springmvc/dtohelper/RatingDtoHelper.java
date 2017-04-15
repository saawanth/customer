package com.springmvc.dtohelper;

public interface RatingDtoHelper<M, D> {

	 public M dtoToModel(D dto);

	  public D modelToDto(M model);
	
}
