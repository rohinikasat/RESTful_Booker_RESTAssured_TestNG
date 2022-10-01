package util;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtility {

	public static String postCreateAuthTokenTest() {
		JSONObject request = new JSONObject();
		request.put("username", "admin");
		request.put("password", "password123");

		Response response = given().header("Content-Type", "application/json").body(request.toJSONString())
				.post("https://restful-booker.herokuapp.com/auth");
		JsonPath jsonPathEvaluator = response.jsonPath();
		return jsonPathEvaluator.get("token");
	}

	public static int postCreateBooking() {
		 int id;

		JSONObject request1 = new JSONObject();
		request1.put("checkin", "2018-01-01");
		request1.put("checkout", "2019-01-01");
		JSONObject request = new JSONObject();
		request.put("firstname", "Jim");
		request.put("lastname", "Brown");
		request.put("totalprice", 111);
		request.put("depositpaid", true);
		request.put("bookingdates", request1);
		request.put("additionalneeds", "Breakfast");

		Response response = given().header("Content-Type", "application/json").body(request.toJSONString()).when()
				.post("https://restful-booker.herokuapp.com/booking");

		return response.jsonPath().get("bookingid");
	}

}
