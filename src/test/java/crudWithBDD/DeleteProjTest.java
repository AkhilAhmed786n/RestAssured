package crudWithBDD;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import static io.restassured.RestAssured.*;

public class DeleteProjTest {
	
	@Test
	public void deleteTest()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_802")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
	}

}
