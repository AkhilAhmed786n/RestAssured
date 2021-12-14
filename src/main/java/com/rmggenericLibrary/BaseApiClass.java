package com.rmggenericLibrary;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass {
	
	
		public DatabaseUtility dutils=new DatabaseUtility();
		public JavaUtility jutils=new JavaUtility();
		public JsonUtility jsonutils=new JsonUtility();
		
		@BeforeSuite
		public void connectToDatabase() throws Throwable 
		{
			dutils.connectToDatabase();
		}
		
		@AfterSuite
		public void closeConnection() throws Throwable
		{
			dutils.closeConnection();
		}
	

}
