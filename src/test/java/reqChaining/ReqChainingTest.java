package reqChaining;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqChainingTest {
	
	@Test
	public void reqChainingTest()
	{
		
		Response resp = given().get("http://localhost:8084/projects");
		String projId = resp.jsonPath().get("[3].projectId");
		System.out.println(projId);
		
		given().pathParam("proId", projId)
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.log().all();
		
	}

}
