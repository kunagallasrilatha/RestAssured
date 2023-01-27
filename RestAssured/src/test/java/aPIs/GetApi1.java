package aPIs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApi1 {

	@Test
	public void getbookid() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		Response response = request.get();
		Assert.assertNotNull(response.getBody().asPrettyString());
		Assert.assertEquals(response.statusCode(), 200, "both are equal");
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		System.out.println(response.getBody().asPrettyString());

	}

	@Test
	public void getbooking() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking/2");

		Response response = request.get();
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asPrettyString());

		JsonPath path = response.getBody().jsonPath();
		System.out.println(path.get("firstname"));
		System.out.println(path.get("lastname"));
		assertEquals(path.getString("firstname"), "Eric");
	}
}
