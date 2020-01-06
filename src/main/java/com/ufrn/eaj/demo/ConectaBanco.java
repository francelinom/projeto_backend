package com.ufrn.eaj.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class ConectaBanco {
	
	private static final String DRIVER = "org.postgresql.Driver";   
	private static final String URL = "jdbc:postgresql://SERVIDOR:PORTA/BANCO?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";   
	private static final String USERNAME = "USERNAME";   
	private static final String PASSWORD = "PASSWORD"; 
	
	
	public static Connection getConnection() throws SQLException {
		try {   
			Class.forName(DRIVER);   
		} catch (ClassNotFoundException ex) {   
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");   
			return null;   
		}   
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);   
		return conn;   
	}
}