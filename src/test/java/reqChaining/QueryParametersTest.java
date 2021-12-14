package reqChaining;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import static io.restassured.RestAssured.*;

public class QueryParametersTest {
	
	@Test
	public void queryparametersTest()
	{
		given()
		.queryParam("page", "2")
		.when().get("https://reqres.in/api/users")
		.then()
		.log().all();
	}

}
