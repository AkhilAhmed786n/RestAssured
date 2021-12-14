package crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectTest {
	
	@Test
	public void getProjectTest()
	{
		
		when().get("http://localhost:8084/projects/TY_PROJ_602")
		.then().
		assertThat().
		statusCode(200).
		log().all();
	}

}
