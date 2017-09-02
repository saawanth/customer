package com.serv.springjdbc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.serv.springjdbc.beans.Emp;;

public class EmpDao {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int save(Emp p){
	String sql="insert into employee(idEmp,empfir,emplast,salary,desig,location) values("+p.getId()+",'"+
p.getFirstname()+"','"+p.getLastname()+"'," + p.getSalary()+ ",'" + p.getDesignation() + "','" + p.getLocation()+" ') ";
	return template.update(sql);
}
public int update(Emp p){
	System.out.println(p.getId() + p.getFirstname() + p.getDesignation() + p.getLastname()
	 + p.getSalary() + p.getLocation());
	String sql="update employee set empfir='"+p.getFirstname()+"',emplast='"+p.getLastname()+"', salary="+
	p.getSalary()+", desig='"+p.getDesignation()+"',location='"+p.getLocation()+"' where idEmp="+p.getId();
	return template.update(sql);
}
public int delete(int id){
	String sql="delete from employee where idEmp="+id+"";
	return template.update(sql);
}
public Emp getEmpById(int id){
	String sql="select * from employee where idEmp="+id+"";
	return template.queryForObject(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
	/*return template.queryForObject(sql,new RowMapper<Emp>() {
		public Emp mapRow(ResultSet rs, int row) throws SQLException {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setFirstname(rs.getString(2));
			e.setLastname(rs.getString(3));
			e.setSalary(rs.getFloat(4));
			e.setDesignation(rs.getString(5));
			e.setLocation(rs.getString(6));
			return e;
		}
	});*/
}
public List<Emp> getEmployees(){
	return template.query("select * from employee",new RowMapper<Emp>(){
		public Emp mapRow(ResultSet rs, int row) throws SQLException {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setFirstname(rs.getString(2));
			e.setLastname(rs.getString(3));
			e.setSalary(rs.getFloat(4));
			e.setDesignation(rs.getString(5));
			e.setLocation(rs.getString(6));
			return e;
		}
	});
}
}
