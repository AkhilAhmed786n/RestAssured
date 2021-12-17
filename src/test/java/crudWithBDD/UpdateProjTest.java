package crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rmggenericLibrary.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjTest {
	
	@Test
	public void updateTest()
	{
		JavaUtility jutils=new JavaUtility();
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","salma"+jutils.generateRandomNumber());
		jObj.put("projectName", "Shahruk"+jutils.generateRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1016")
		.then().assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
