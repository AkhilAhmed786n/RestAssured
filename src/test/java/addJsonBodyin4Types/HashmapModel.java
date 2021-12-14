package addJsonBodyin4Types;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class HashmapModel {
	
	@Test
	public void hashmapModel()
	{
		HashMap hm = new HashMap();
		hm.put("createdBy", "Manager1");
		hm.put("projectName", "TestYantraRest");
		hm.put("status", "NotCompleted");
		hm.put("teamSize", 3);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(hm)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
	}

}

