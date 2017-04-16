package com.srujanonit.app.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<ID extends Serializable, D> {
	
	List<D> findAll();
	
	D find(ID id);
	
	D save(D entity);
	
	D update(D entity);
	
	D delete(Long id);

}
