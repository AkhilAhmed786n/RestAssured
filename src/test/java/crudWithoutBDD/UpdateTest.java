package crudWithoutBDD;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateTest {
	
	@Test
	public void updateTest()
	{
		Random r=new Random();
//		 int randomNum = r.nextInt(3000);
		
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","Allah");
		jObj.put("projectName", "Noorullah");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 1);
		
		
		
		  RequestSpecification reqs = given()
		.contentType(ContentType.JSON)
		.body(jObj);
		
		  Response res = reqs.put("http://localhost:8084/projects/TY_PROJ_007");
		  ValidatableResponse vres = res.then();
		  vres.assertThat().
		  statusCode(200);
		  vres.log();
		
		
	}

}
