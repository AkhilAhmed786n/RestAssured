package reqChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;



public class Scenario {
	
	@Test
	public void scenario() 
	{
		Random r=new Random();
		 int randomNum = r.nextInt(3000);
		
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","Me"+randomNum);
		jObj.put("projectName", "ScenarioCreated"+randomNum);
		jObj.put("status", "Completed");
		jObj.put("teamSize", 4);
		
		
		
		 Response project = given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject");
		 
		  String projId = project.jsonPath().get("projectId");
		  System.out.println(projId);
		  
		 Response createdproj = given().pathParam("proId", projId)		 
		.when().get("http://localhost:8084/projects/{proId}");
		
		 String projName=createdproj.jsonPath().get("projectName");
		
		System.out.println(projName);
		 
		
		
		
		
	
		
		
		
		
		
	}

}
