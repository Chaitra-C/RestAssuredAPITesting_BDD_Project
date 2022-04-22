package RestassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PUT_request {
	
	public static HashMap map = new HashMap();
	String empName = RestUtils.EmpName();
	String empSal = RestUtils.Sal();
	String age = RestUtils.Age();
    int empID = 11254;
    
    @BeforeClass
    public void putData() {
    	map.put("name",empName);
    	map.put("salary", empSal);
    	map.put("empAge", age);
    
	
	String baseURI = "http://dummmy.restAPIexample.com/api/v1";
	String basePath = "/update/"+empID;

}
    @Test
    public void testPut() 
    {
    	given()
    		.contentType("application/json")
    		.body(map)
    	.when()
    		.put()
    	.then()
    	.statusCode(200)
    	.log().all();
    	
    	
    }
}
