package aPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api1 {

	@Test
	public void apiTest_01() {

		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking");

		Response respone = request.get();
		System.out.println(respone.getBody().asPrettyString());
		System.out.println(respone.getStatusCode());
		System.out.println(respone.getStatusLine());

	}

	@Test
	public void specificseriveri() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking/7");

		Response response = request.get();

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		Assert.assertNotNull(response.getBody().asPrettyString());
		System.out.println(response.getBody().asPrettyString());

		JsonPath path = response.getBody().jsonPath();

		System.out.println(path.getString("firstname"));
		System.out.println(path.getString("lastname"));
		System.out.println(path.getString("totalprice"));
		System.out.println(path.getString("depositpaid"));

		Assert.assertEquals(path.getString("firstname"), "Mary");
		Assert.assertEquals(path.getString("lastname"), "Brown");
		Assert.assertEquals(path.getString("totalprice"), "170");
		Assert.assertEquals(path.getString("depositpaid"), "false");

	}

}
