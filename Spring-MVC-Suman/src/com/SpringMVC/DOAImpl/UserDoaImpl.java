package com.SpringMVC.DOAImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringMVC.DOA.DoaUserInterface;
import com.SpringMVC.Model.Movies;
import com.SpringMVC.Model.User;

public class UserDoaImpl implements DoaUserInterface{

	
	private JdbcTemplate jdbcTemplate;
	 @Autowired
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(User user) {
		String sql="insert into users(username,age) values(?,?)";
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[]{user.getName(),user.getAge()});
		
	}

	@Override
	public String find(String username) {
		String user=username;
		jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select moviename from movies where username=?";
		String age=jdbcTemplate.queryForObject(sql, new Object[] { user }, String.class);
		
		return age;
	}

}
