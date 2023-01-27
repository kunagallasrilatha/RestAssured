package aPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutApi {

	@Test
	public void postapi() {
		String requestdata = "{\r\n" + "    \"firstname\" : \"selenium\",\r\n" + "    \"lastname\" : \"java\",\r\n"
				+ "    \"totalprice\" : 1000,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		request.contentType(ContentType.JSON);
		request.body(requestdata);
		Response response = request.post();
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());

		JsonPath path = response.getBody().jsonPath();
		Assert.assertEquals(path.getString("booking.firstname"), "selenium");
		Assert.assertEquals(path.getString("booking.lastname"), "java");

	}
}
