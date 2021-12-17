package crudWithoutBDD;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rmggenericLibrary.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateTest {
	
	@Test
	public void updateTest()
	{
		JavaUtility jutils=new JavaUtility();
		
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","SubanAllah"+jutils.generateRandomNumber());
		jObj.put("projectName", "Allahuakbar"+jutils.generateRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 1);
		
		
		
		  RequestSpecification reqs = given()
		.contentType(ContentType.JSON)
		.body(jObj);
		
		  Response res = reqs.put("http://localhost:8084/projects/TY_PROJ_1017");
		  ValidatableResponse vres = res.then();
		  vres.assertThat().
		  statusCode(200);
		  vres.log();
		
		
	}

}
