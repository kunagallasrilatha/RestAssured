package aPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetService {

	@Test
	public void Getser() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/api/users/2");

		Response response = request.get();
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getTime());

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");

	}

}
