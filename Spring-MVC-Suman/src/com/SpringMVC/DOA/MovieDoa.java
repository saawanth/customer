package com.SpringMVC.DOA;

import com.SpringMVC.Model.Movies;
import com.SpringMVC.Model.User;

public interface MovieDoa {
	public void insert(Movies movie);

	public String find(String moviename);
}
