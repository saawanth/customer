package com.connectionpool.com;

public class Connections {	
	
	public String url;
	public String name; 
	public String password;
	public int MAX_CONNECTIONS;
	
	private Connections(){
		init();
	}
	
	private static Connections con = new Connections();
	
	public static Connections getInstance(){
		return con;		
	}
	
	private void init(){
		url = "jdbc:postgresql://localhost:5432/JDBCAssignment";
		name = "postgres";
		password = "renu";
		MAX_CONNECTIONS = 5;		
	}
}
