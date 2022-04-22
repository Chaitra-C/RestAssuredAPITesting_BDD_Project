package RestassuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Demo6_BasicValidations_XML {
	@Test(priority=1)
	void testSingleContent() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.body("CUSTOMER.ID",equalTo("15"))
		.log().all();
	}
	@Test(priority=2)
	void testMultipleContents() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.body("CUSTOMER.ID",equalTo("15"))
		.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
		.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
		.body("CUSTOMER.CITY",equalTo("Seattle"));
	}
	@Test(priority=3)
	void testMultipleContentsinOneGo() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	@Test(priority=4)
	void testUsingXPath1() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
	}
	@Test(priority=5)
	void testUsingXPath2() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
		.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		.log().all();
	
	
}
}
