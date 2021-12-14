package responseTypes;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponse {
	
	@Test
	public void staticResponse()
	{
		String expData="Pokemon";
		Response response = when().get("http://localhost:8084/projects");
		response.then().assertThat().statusCode(200);
		
		String actData = response.jsonPath().get("[2].projectName");
		
		if(actData.equals(expData))
		{
			System.out.println(actData);
		}
		
		
	}

}
