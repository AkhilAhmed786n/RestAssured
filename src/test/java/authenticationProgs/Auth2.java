package authenticationProgs;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {
	
	@Test
	public void auth2()
	{
		
		baseURI="http://coop.apps.symfonycasts.com";
		
		Response res = given().
		formParam("client_id", "Auth_App")
		.formParam("client_secret", "2a52a4affcd82aa66f4a918acbf74d4c")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://Example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
//		System.out.println(res.prettyPrint());
		
		String token=res.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "2534")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log()
		.all();
	}

}
