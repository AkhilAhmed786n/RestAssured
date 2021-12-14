package addJsonBodyin4Types;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class JsonFileModel {
	
	@Test
	public void jsonFileModel()
	{
		File file = new File("./Data/jsonfile.json");
		

		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
	}

}
