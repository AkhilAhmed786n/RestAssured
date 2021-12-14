package authenticationProgs;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {

	
	@Test
	public void bearerToken()
	{
		given()
		.auth().oauth2("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")
		.when().get("https://api.github.com/user/repos")
		.then().log().all();
	}
}
