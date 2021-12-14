package reqChaining;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqChainingTest2 {
	
	@Test
	public void reqChainingTest2()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "jani");
		jObj.put("projectName", "Tyss6");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 3);
		
		 Response create = given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject");
		 
		String projectid =create.jsonPath().get("projectId");
		
		given().pathParam("proId", projectid)
		.when().delete("http://localhost:8084/projects/{proId}").then().log().all();
		
		
		
	}

}
