package addJsonBodyin4Types;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmggenericLibrary.JavaUtility;
import com.rmgyantra.projectLibrary.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectDataProviderTest {
	
	JavaUtility jutils= new JavaUtility();
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] obj=new Object[2][4];
		
		obj[0][0]="AkhilData1"+jutils.generateRandomNumber();
		obj[0][1]="Dataprovider3"+jutils.generateRandomNumber();
		obj[0][2]="Completed";
		obj[0][3]=11;
		
		obj[1][0]="AkhilData2"+jutils.generateRandomNumber();
		obj[1][1]="Dataprovider4"+jutils.generateRandomNumber();
		obj[1][2]="Completed";
		obj[1][3]=13;
		return obj;
		}

	@Test(dataProvider="provideData")
	
	public void ProjectData(String createdBy, String projectName, String status, int teamsize)
	{
		PojoLibrary pl=new PojoLibrary(createdBy, projectName, status, teamsize);
		
		given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}
}
