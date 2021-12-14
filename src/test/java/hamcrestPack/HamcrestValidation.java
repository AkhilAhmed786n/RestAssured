package hamcrestPack;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HamcrestValidation {
	
	@Test
	public void hamcrestvalidation()
	{
		when()
		.get("http://localhost:8084/projects")
		.then().assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
		.assertThat().body("[0].projectName",Matchers.equalTo("SDET_2"))
		.log().all();
		
	}

}
