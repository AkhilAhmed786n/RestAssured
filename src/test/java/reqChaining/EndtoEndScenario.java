package reqChaining;

import org.testng.annotations.Test;

import com.rmggenericLibrary.BaseApiClass;
import com.rmggenericLibrary.DatabaseUtility;
import com.rmggenericLibrary.Endpoints;
import com.rmggenericLibrary.JavaUtility;
import com.rmgyantra.projectLibrary.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

public class EndtoEndScenario extends BaseApiClass {
	
	@Test
	public void endtoendScenario() throws Throwable
	{
		
		
		baseURI="http://localhost";
		port= 8084;
		
		PojoLibrary pl=new PojoLibrary("shahruk3"+jutils.generateRandomNumber(),"endtoendScenario3"+jutils.generateRandomNumber(), "Completed" , 7);
		
		Response res = given().contentType(ContentType.JSON).body(pl)
		.when().
		post(Endpoints.createProj);
		res.then().log().all();
		
		String projId=jsonutils.JsonPathFinder("projectId", res);
		System.out.println(projId);
		
		Response res1 = given().pathParam("proId", projId)
				.when()
				.get("/projects/{proId}");
				res1.then().log().all();
		
		String projName=jsonutils.JsonPathFinder("projectName", res1);
		System.out.println(projName);
		
		
		//connecting to database
//		dutils.connectToDatabase();
		
		ResultSet result= dutils.executeQuery("select * from project");
		
		while(result.next())
		{
			if(result.getString(4).equals(projName))
			{
				System.out.println(projName+" is matching");
			}
		}
		
		//closing the connection to database
//		dutils.closeConnection();
		
	}

}
