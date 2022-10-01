package test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import util.TestUtility;

public class BaseClass {
	
	public String authToken;
	public int id;
	
	@BeforeTest
	public void init() {
		authToken = TestUtility.postCreateAuthTokenTest();
		id = TestUtility.postCreateBooking();
	}
	

	

}
