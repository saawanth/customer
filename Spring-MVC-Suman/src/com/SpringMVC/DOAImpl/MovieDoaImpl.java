package com.SpringMVC.DOAImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.SpringMVC.DOA.MovieDoa;
import com.SpringMVC.Model.Movies;

public class MovieDoaImpl implements MovieDoa{
	
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Movies movie) {
	
		String sql="insert into movies(moviename,genre,username) values(?,?,?)";
		jdbcTemplate.update(sql,new Object[]{movie.getMoviename(),movie.getGenre(),movie.getUsername()});
	}

	@Override
	public String find(String username) {

		String sql="select moviename from movies where username=?";
		String movie=jdbcTemplate.queryForObject(sql,new Object[]{username},String.class);
		return movie;
	}
	
}
