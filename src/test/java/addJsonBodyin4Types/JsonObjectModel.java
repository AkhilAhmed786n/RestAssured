package addJsonBodyin4Types;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class JsonObjectModel {
	
	
	@Test
	public void jsonObjectModel()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Manager4");
		jObj.put("projectName", "Tyss4");
		jObj.put("status", "NotCompleted");
		jObj.put("teamSize", 6);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
