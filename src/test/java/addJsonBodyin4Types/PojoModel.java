package addJsonBodyin4Types;

import java.util.Random;

import org.testng.annotations.Test;

import com.rmgyantra.projectLibrary.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PojoModel {
	
	@Test
	
	public void pojoModel()
	{
		Random r=new Random();
		int randomVariable = r.nextInt(3000);
		
		PojoLibrary pj=new PojoLibrary("Manager3", "Tyss3", "Complete", 6);
		
		given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

}
