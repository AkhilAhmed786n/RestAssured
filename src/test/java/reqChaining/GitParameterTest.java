package reqChaining;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GitParameterTest {
	
	@Test
	public void gitParameterTest()
	{
		
		given().pathParam("username", "Arun1897")
		.queryParam("sort", "created")
		.when().get("https://api.github.com/users/{username}/repos")
		.then().log().all();
	}

}
