package crudWithoutBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rmggenericLibrary.JavaUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	
	@Test
	public void createProjectTest() 
	{
		JavaUtility jutils=new JavaUtility();
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "AkhilSyed"+jutils.generateRandomNumber());
		jObj.put("projectName", "RestFull"+jutils.generateRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 8);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jObj);
		
		Response response = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse vres = response.then();
		vres.assertThat().statusCode(201);
		vres.log().all();
		
		
	}

}
