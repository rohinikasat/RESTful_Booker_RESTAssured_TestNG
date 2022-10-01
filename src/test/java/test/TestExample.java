package test;

import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;



public class TestExample {
	
	@Test
	public void test_1(){
		
		Response response = get("https://restful-booker.herokuapp.com/booking");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_2() {
		baseURI = "https://restful-booker.herokuapp.com";
	
		//in same statement getting the url and checking the status code and body has booking Id
		given()
			.get("/booking")
		.then()
			.statusCode(200)
			.body("bookingid", hasItems(1655,2235));
		
	}

}
