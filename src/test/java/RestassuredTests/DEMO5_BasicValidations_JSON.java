package RestassuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class DEMO5_BasicValidations_JSON {
	@Test(priority=1)
	public void testStatusCode() {
		
		given()
		
		.when()
		.get("http://jsonplaceholder.typicode.com/posts/5")
		
		.then()
		.statusCode(200);
		//.log().all();
		
		
	}
	@Test(priority=2)
	public void testLogging() {
		given()
		
		.when()
		.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
		.statusCode(200)
		.log().all();
	}
	//verifying single content in the response body
	@Test(priority=3)
	public void testsingleContent() {
		given()
		
		.when()
		.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
		.statusCode(200)
		.body("RestResponse.result.name", equalTo("India"));	
	}
	//verifying multiple contents in response body
	@Test(priority=4)
	public void testMultipleContent() {
		given()
		
		.when()
		.get("http://services.groupkt.com/country/get/all")
		.then()
		.statusCode(200)
		.body("RestResponse.result.name", hasItems("India","Australia","United States of America"));	
	}
	//Setting parameters and headers
	//verifying multiple contents in response body
		@Test(priority=5)
		public void testParametersandHeaders() {
			given()
			.param("MyName","John")
			.header("MyHeader","Indian")
			
			.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
			.statusCode(200)
			.log().all();	
		}
	
	
	

}
