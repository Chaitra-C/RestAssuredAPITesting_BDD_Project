package RestassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class Demo2_POST_request {
	public static HashMap map= new HashMap();
	@BeforeClass
	public void postData() {
		
		
		map.put("FirstName",RestUtils.getFirstName());
		map.put("LastName",RestUtils.getLastName());
		map.put("UserName",RestUtils.getUserName());
		map.put("Password",RestUtils.getPassword());
		map.put("Email",RestUtils.getEmail());
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";
	}


	@Test
	public void testPost() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
		.statusCode(200)
		.assertThat().body("SuccessCode", equalTo("Operation Success"));
		
	}
}
