package com.srujanonit.app.dao.repo;

import java.io.Serializable;
import java.util.List;


public interface BaseRepo<ID extends Serializable, M> {
	public M save(M model);
	
	public M find(long id);
	
	public M update(M model);
	
	public M delete(Long id);
	
	public List<M> getAll();
	
}
