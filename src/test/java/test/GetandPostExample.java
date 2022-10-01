package test;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class GetandPostExample {
	
	@Test
	public void getBookingTest() {
		given().get("https://restful-booker.herokuapp.com/booking/3671")
			.then().statusCode(200)
			.body("bookingdates.checkin", equalTo("2018-01-01"));
	}
	
	@Test
	public void postCreateToken() {
		JSONObject request = new JSONObject();
		request.put("username", "admin");
		request.put("password", "password123");
		
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.post("https://restful-booker.herokuapp.com/auth")
		.then()
			.statusCode(200)
			.log()
			.all();
		
		
		
	}

}
