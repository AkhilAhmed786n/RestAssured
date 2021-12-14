package com.rmggenericLibrary;

import io.restassured.response.Response;


public class JsonUtility {
	
	public String JsonPathFinder(String jsonpath, Response resp )
	{
		
		String text=resp.jsonPath().getString(jsonpath);
		return text;
						
	}

}
