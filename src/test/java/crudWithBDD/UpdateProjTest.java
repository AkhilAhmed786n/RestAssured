package crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjTest {
	
	@Test
	public void updateTest()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","Akhilahmed");
		jObj.put("projectName", "Noor");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_006")
		.then().assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
