package com.rmggenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	public Connection con=null;
	public ResultSet result;
	
	public void connectToDatabase() throws Throwable
	{
		try {
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection() throws SQLException 
	{
		con.close();
	}
	
	
	public ResultSet executeQuery(String query) throws Throwable
	{
		result = con.createStatement().executeQuery(query);
		return result;
		
	}

}
