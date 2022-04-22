package RestassuredTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Demo4_DELETE_request {
	
	@Test
	public void deleteEmployeeRecord()
	{
	String baseURI = "http://dummy.restapiexample.com/api/v1";
	String basePath = "/delete/11493";
	
	Response response =
	
	given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
	
	String jsonAsString = response.asString();
	Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"),true);
	}
}
