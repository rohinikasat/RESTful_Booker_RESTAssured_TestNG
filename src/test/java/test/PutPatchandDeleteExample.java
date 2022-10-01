package test;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PutPatchandDeleteExample extends BaseClass{
	String cookie;
	
	@Test(priority = 1)
	public void putUpdateBooking() {
		
		JSONObject request1 = new JSONObject();
		request1.put("checkin", "2018-02-02");
		request1.put("checkout", "2021-05-01");
		JSONObject request2 = new JSONObject();
		request2.put("firstname", "James");
		request2.put("lastname", "Brown");
		request2.put("totalprice", 111);
		request2.put("depositpaid", true);
		request2.put("bookingdates", request1);
		request2.put("additionalneeds", "Breakfast");
		System.out.println(authToken);
		System.out.println(id);
		
		cookie = "token=" + authToken;
		given()
			.auth()
			.oauth2(authToken)
			.header("Content-Type", "application/json")
			.header("Accept","application/json")
			.header("Cookie",cookie)
			.body(request2)
		.when()
			.put("https://restful-booker.herokuapp.com/booking/"+id)
		.then()
			.statusCode(200);
			
	}
	
	@Test(priority=2)
	public void deleteBooking() {
		cookie = "token=" + authToken;
		
		Response response = given()
			.header("Content-Type","application/json")
			.header("Cookie", cookie)
		.when()
			.delete("https://restful-booker.herokuapp.com/booking/"+id);
		
		Assert.assertEquals(201, response.getStatusCode());
		System.out.println("Response" + response.asString());
		
		
	}

}
