package responseTypes;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponse {
	
	@Test
	public void dynamicResponse()
	{
		String expData="pojoProj";
		Response response = when().get("http://localhost:8084/projects");
		response.then().assertThat().statusCode(200);
		String con = response.getHeader("Connection");
		
		System.out.println(con);
		
		List<String> listData = response.jsonPath().get("projectName");
		System.out.println(response.getDetailedCookie("JSESSIONID"));
		
		for(String actData:listData)
		{
//			System.out.println(actData);
			if(actData.equals(expData))
			{
				System.out.println(actData+" is Present.");
				break;
			}
		}
		
	}

}
